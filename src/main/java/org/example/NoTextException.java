package org.example;

public class NoTextException extends Exception {
    public NoTextException() {
        super("No text to remove!");
    }
}
