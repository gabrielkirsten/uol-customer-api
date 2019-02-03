package br.com.uol.customerapi.domain.metaweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationSearchMetaWeather {

    @JsonProperty("title")
    private String title;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("latt_long")
    private String lattitudeAndlongitude;

    @JsonProperty("woeid")
    private String woeid;

    @JsonProperty("distance")
    private BigDecimal distance;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLattitudeAndlongitude() {
        return lattitudeAndlongitude;
    }

    public void setLattitudeAndlongitude(String lattitudeAndlongitude) {
        this.lattitudeAndlongitude = lattitudeAndlongitude;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
}
