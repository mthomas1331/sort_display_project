package org.spartaglobal.controllers;

public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
