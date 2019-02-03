package br.com.uol.customerapi.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException() {
        super();
    }

    public LocationNotFoundException(String message) {
        super(message);
    }

}
