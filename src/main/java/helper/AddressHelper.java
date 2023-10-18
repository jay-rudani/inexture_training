package helper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddressHelper {

	// method used to get field values by Regular Expression
	public static List<String> getAddressFields(String regex, HttpServletRequest request,
			HttpServletResponse response) {
		Pattern pattern = Pattern.compile(regex);
		List<String> paramValues = new ArrayList<>();

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			Matcher matcher = pattern.matcher(paramName);
			if (matcher.matches()) {
				for (String item : request.getParameterValues(paramName)) {
					paramValues.add(item);
				}
			}
		}
		return paramValues;
	}
}
