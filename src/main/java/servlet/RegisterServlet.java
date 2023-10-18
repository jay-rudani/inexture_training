package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserAddressDAO;
import helper.AddressHelper;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;
import utility.UUIDGenerator;

@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// getting parameters from the request
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birth_date = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("languages");
		String uuid = UUIDGenerator.generateUUID();

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
				Country country = new Country(Integer.parseInt(countries.get(i)));
				State state = new State(Integer.parseInt(states.get(i)), country.getId());
				City city = new City(Integer.parseInt(cities.get(i)), state.getId());
				Address address = new Address(addressLine1.get(i), addressLine2.get(i), city, state, country,
						pincodes.get(i));
				addresses.add(address);
			}
		}

		InputStream inputStream = null;
		Part filePart = request.getPart("profilepic");
		if (filePart != null)
			inputStream = filePart.getInputStream();

		int row = UserAddressDAO.addRecord(uuid, first_name, last_name, email, username, password,
				java.sql.Date.valueOf(birth_date), gender, languages, inputStream, addresses);

		if (row > 0)
			out.println("<script>alert('Registered!');</script>");
		else
			out.println("<script>alert('Email, Username, UUID already existed');</script>");
	}
}
