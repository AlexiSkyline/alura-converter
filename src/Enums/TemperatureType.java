package Enums;

public enum TemperatureType {
    CELSIUS("Degrees Celsius", "°C"),
    FAHRENHEIT("Degrees Fahrenheit", "°F"),
    KELVIN("Degrees Kelvin", "K");

    private String message;
    private String symbol;

    TemperatureType(String message, String symbol) {
        this.message = message;
        this.symbol = symbol;
    }

    public String getMessage() {
        return message;
    }

    public String getSymbol() {
        return symbol;
    }
}
