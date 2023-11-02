package org.icc.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

public class ConvertFromToName {

    public static String getName(ResponseEntity<String> response, String currencyCode) throws JsonProcessingException {
        // checking if the request was successful
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            // parsing JSON response
            JsonNode jsonNode = new ObjectMapper().readTree(responseBody);

            // accessing "supported_codes" array
            JsonNode supportedCodes = jsonNode.get("supported_codes");

            // Iterate array and find value
            for (JsonNode codeInfo : supportedCodes) {
                String currencyCodeData = codeInfo.get(0).asText();
                if (currencyCode.equals(currencyCodeData)) {
                    return codeInfo.get(1).asText();
                }
            }
        }
        return null;
    }
}
