package br.com.uol.customerapi.domain.ipvigilante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorIpVigilante {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("numberErrors")
    private Integer numberErrors;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNumberErrors() {
        return numberErrors;
    }

    public void setNumberErrors(Integer numberErrors) {
        this.numberErrors = numberErrors;
    }
}
