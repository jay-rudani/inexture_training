package org.icc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConversionError {

    private String result;
    private String documentation;
    @JsonProperty("terms-of-use")
    private String termsOfUse;
    @JsonProperty("error-type")
    private String error_type;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    @Override
    public String toString() {
        return "ConversionError{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + termsOfUse + '\'' +
                ", error_type='" + error_type + '\'' +
                '}';
    }
}
