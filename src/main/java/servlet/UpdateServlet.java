package servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AddressDAO;
import dao.CityDAO;
import dao.CountryDAO;
import dao.StateDAO;
import dao.UserAddressDAO;
import dto.User;
import helper.AddressHelper;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;

@WebServlet("/UpdateServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		User updatedUser = new User();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String userUUID = request.getParameter("user_uuid");
		InputStream inputStream = null;

		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String birth_date = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("languages");
		Part filePart = request.getPart("profile_picture");
		String base64ImageData = request.getParameter("profile_pic_data").substring("data:image;base64,".length());

		if (filePart != null)
			inputStream = filePart.getInputStream();

		if (filePart.getSize() > 0) {
			if (filePart != null) {
				inputStream = filePart.getInputStream();
			}
		} else {
			byte[] imageData = Base64.getDecoder().decode(base64ImageData);
			inputStream = new ByteArrayInputStream(imageData);
			updatedUser.setProfile_pic(imageData);
		}

		updatedUser.setFirstName(first_name);
		updatedUser.setLastName(last_name);
		updatedUser.setEmail(email);
		updatedUser.setUserName(username);
		updatedUser.setBirthDate(Date.valueOf(birth_date));
		updatedUser.setGender(gender);

		if (languages != null) {
			StringBuilder selectedValues = new StringBuilder();
			for (String language : languages) {
				selectedValues.append(language).append(", ");
			}
			selectedValues.setLength(selectedValues.length() - 2);
			updatedUser.setKnownLanguages(selectedValues.toString());
		}

		List<String> addressId = AddressHelper.getAddressFields("items\\[\\d+\\]\\[addressId\\]", request, response);
		List<String> addressLine1 = AddressHelper.getAddressFields("items\\[\\d+\\]\\[addressLine1\\]", request,
				response);
		List<String> addressLine2 = AddressHelper.getAddressFields("items\\[\\d+\\]\\[addressLine2\\]", request,
				response);
		List<String> cities = AddressHelper.getAddressFields("items\\[\\d+\\]\\[city\\]", request, response);
		List<String> states = AddressHelper.getAddressFields("items\\[\\d+\\]\\[state\\]", request, response);
		List<String> countries = AddressHelper.getAddressFields("items\\[\\d+\\]\\[country\\]", request, response);
		List<String> pincodes = AddressHelper.getAddressFields("items\\[\\d+\\]\\[pincode\\]", request, response);
		List<Address> addresses = new ArrayList<>();

		if (!pincodes.isEmpty()) {
			for (int i = 0; i < pincodes.size(); i++) {
				Country country = CountryDAO.getCountry(
						Integer.parseInt(countries.get(i))); /* new Country(Integer.parseInt(countries.get(i))); */
				State state = StateDAO.getState(Integer
						.parseInt(states.get(i))); /* new State(Integer.parseInt(states.get(i)), country.getId()); */
				City city = CityDAO.getCity(Integer
						.parseInt(cities.get(i))); /* new City(Integer.parseInt(cities.get(i)), state.getId()); */
				int address_id = addressId.get(i).isEmpty() ? 0 : Integer.parseInt(addressId.get(i));
				Address address = new Address(address_id, addressLine1.get(i), addressLine2.get(i), city, state,
						country, pincodes.get(i));
				addresses.add(address);
			}
		}

		AddressDAO.deleteSavedAddress(addressId, userUUID);
		if (UserAddressDAO.updateRecord(userId, userUUID, updatedUser, inputStream, addresses) == 1) {
			if (request.getSession().getAttribute("manageUserData") != null) {
				request.getSession().removeAttribute("manageUserData");
				response.sendRedirect("viewUsers.jsp");
			} else {
				if (request.getSession().getAttribute("manageUserData") != null) {
					request.getSession().removeAttribute("manageUserData");
				}
				updatedUser.setId(userId);
				updatedUser.setUser_uuid(userUUID);
				updatedUser.setAddresses(addresses);
				request.getSession().setAttribute("userData", updatedUser);
				response.sendRedirect("home.jsp");
			}
		} else {
			System.out.println("ERROR");
		}

	}
}
