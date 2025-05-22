package com.maveric.pgms.exceptions;

public class PayingGuestDetailsNotFoundException extends Exception {
    public PayingGuestDetailsNotFoundException() {
        super();
    }

    public PayingGuestDetailsNotFoundException(String message) {
        super(message);
    }

    public PayingGuestDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayingGuestDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PayingGuestDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
