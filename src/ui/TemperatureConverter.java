package ui;

import Enums.TemperatureType;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class TemperatureConverter {
    TemperatureType initTypeValue;
    TemperatureType finalTypeValue;
    double value;

    public void startTemperatureConversion(double value) {
        this.value = value;
        this.initTypeValue = this.showSelectOptionTemperature("Choose initial temperature:");
        this.finalTypeValue = this.showSelectOptionTemperature("Choose the temperature you wish to convert to:");

        if (this.initTypeValue != null && this.finalTypeValue != null)
            this.convertTemperature();
    }

    private TemperatureType showSelectOptionTemperature(String message) {
        Icon alertIcon = UIManager.getIcon("OptionPane.questionIcon");

        String selectedOption = (String) JOptionPane.showInputDialog(
                null,
                message, "Type of temperature",
                JOptionPane.PLAIN_MESSAGE, alertIcon, this.getAllMessagesOptions().toArray(new String[0]),
                null
        );

        return getEnumSelectedOption(selectedOption);
    }

    private List<String> getAllMessagesOptions() {
        return Arrays.stream(TemperatureType.values())
                .map(TemperatureType::getMessage)
                .filter(message -> this.initTypeValue == null || !message.equals(this.initTypeValue.getMessage()))
                .toList();
    }

    private TemperatureType getEnumSelectedOption(String selected) {
        return Arrays.stream(TemperatureType.values())
                .filter(option -> option.getMessage().equals(selected))
                .findFirst()
                .orElse(null);
    }

    private void convertTemperature() {
        double result = 0;

        switch (this.initTypeValue) {
            case CELSIUS -> {
                if (this.finalTypeValue == TemperatureType.FAHRENHEIT) {
                    result = (value * 9 / 5) + 32;
                } else if (this.finalTypeValue == TemperatureType.KELVIN) {
                    result = value + 273.15;
                }
            }
            case FAHRENHEIT -> {
                if (this.finalTypeValue == TemperatureType.CELSIUS) {
                    result = (value - 32) * 5 / 9;
                } else if (this.finalTypeValue == TemperatureType.KELVIN) {
                    result = (value - 32) * 5 / 9 + 273.15;
                }
            }
            case KELVIN -> {
                if (this.finalTypeValue == TemperatureType.CELSIUS) {
                    result = value - 273.15;
                } else if (this.finalTypeValue == TemperatureType.FAHRENHEIT) {
                    result = (value - 273.15) * 9 / 5 + 32;
                }
            }
        }

        String message = String.format("The temperature %.2f%s is %.2f%s", this.value, this.initTypeValue.getSymbol(), result, this.finalTypeValue.getSymbol());
        JOptionPane.showMessageDialog(null, message);
    }
}
