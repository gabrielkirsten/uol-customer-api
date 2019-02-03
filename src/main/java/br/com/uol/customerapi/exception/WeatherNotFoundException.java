package br.com.uol.customerapi.exception;

public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException() {
        super();
    }

    public WeatherNotFoundException(String message) {
        super(message);
    }

}
