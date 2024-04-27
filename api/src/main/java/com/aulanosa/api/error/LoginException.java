package com.aulanosa.api.error;

/**
 * Esta clase representa la excepción personalizada que se lanza cuando el login falla
 */
public class LoginException extends Exception{
    public LoginException(String message) {
        super(message);
    }
}
