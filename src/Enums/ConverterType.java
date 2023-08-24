package Enums;

public enum ConverterType {
    MONEY("Money Converter"),
    TEMPERATURE("Temperature Converter");

    private final String message;

    ConverterType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
