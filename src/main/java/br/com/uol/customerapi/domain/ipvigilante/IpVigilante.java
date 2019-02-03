package br.com.uol.customerapi.domain.ipvigilante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpVigilante {

    @JsonProperty("status")
    private StatusIpVigilante status;

    @JsonProperty("data")
    private DataIpVigilante data;

    @JsonProperty("error")
    private ErrorIpVigilante error;

    public StatusIpVigilante getStatus() {
        return status;
    }

    public void setStatus(StatusIpVigilante status) {
        this.status = status;
    }

    public DataIpVigilante getData() {
        return data;
    }

    public void setData(DataIpVigilante data) {
        this.data = data;
    }

    public ErrorIpVigilante getError() {
        return error;
    }

    public void setError(ErrorIpVigilante error) {
        this.error = error;
    }
}
