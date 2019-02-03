package br.com.uol.customerapi.domain.ipvigilante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataIpVigilante {

    @JsonProperty("ipv4")
    private String ipv4;

    @JsonProperty("hostname")
    private String hostname;

    @JsonProperty("continent_code")
    private String continentCode;

    @JsonProperty("continent_name")
    private String continentName;

    @JsonProperty("country_iso_code")
    private String countryIsoCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("subdivision_1_iso_code")
    private String subdivision1IsoCode;

    @JsonProperty("subdivision_1_name")
    private String subdivision1Name;

    @JsonProperty("subdivision_2_iso_code")
    private String subdivision2IsoCode;

    @JsonProperty("subdivision_2_name")
    private String subdivision2Name;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("metro_code")
    private String metroCode;

    @JsonProperty("time_zone")
    private String timeZone;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("accuracy_radius")
    private String accuracyRadius;

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSubdivision1IsoCode() {
        return subdivision1IsoCode;
    }

    public void setSubdivision1IsoCode(String subdivision1IsoCode) {
        this.subdivision1IsoCode = subdivision1IsoCode;
    }

    public String getSubdivision1Name() {
        return subdivision1Name;
    }

    public void setSubdivision1Name(String subdivision1Name) {
        this.subdivision1Name = subdivision1Name;
    }

    public String getSubdivision2IsoCode() {
        return subdivision2IsoCode;
    }

    public void setSubdivision2IsoCode(String subdivision2IsoCode) {
        this.subdivision2IsoCode = subdivision2IsoCode;
    }

    public String getSubdivision2Name() {
        return subdivision2Name;
    }

    public void setSubdivision2Name(String subdivision2Name) {
        this.subdivision2Name = subdivision2Name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(String metroCode) {
        this.metroCode = metroCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAccuracyRadius() {
        return accuracyRadius;
    }

    public void setAccuracyRadius(String accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }
}
