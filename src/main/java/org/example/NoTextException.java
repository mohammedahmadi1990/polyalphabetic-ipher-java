package org.example;

/**
 * @author Med
 */
public class NoTextException extends Exception {
    public NoTextException() {
        super("No text to remove!");
    }
}
