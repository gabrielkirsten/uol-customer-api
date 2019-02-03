package br.com.uol.customerapi.domain;

import java.math.BigDecimal;

public class Weather {

    private BigDecimal maxTemperature;

    private BigDecimal minTemperature;

    public Weather(BigDecimal maxTemperature, BigDecimal minTemperature) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

}
