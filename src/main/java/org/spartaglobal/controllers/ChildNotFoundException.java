package org.spartaglobal.controllers;

/**
 * This is the exception class for the child nodes method in the binary tree
 *
 */
public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
