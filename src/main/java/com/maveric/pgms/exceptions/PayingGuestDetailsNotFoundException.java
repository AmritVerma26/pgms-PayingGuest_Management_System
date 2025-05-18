package com.maveric.pgms.exceptions;

public class PayingGuestDetailsNotFoundException extends RuntimeException {
    public PayingGuestDetailsNotFoundException(String message) {
        super(message);
    }

    public PayingGuestDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayingGuestDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public PayingGuestDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
