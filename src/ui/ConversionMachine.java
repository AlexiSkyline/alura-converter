package ui;

import Enums.ConverterType;
import Enums.MachineState;

import javax.swing.*;

import java.math.BigDecimal;

import static Enums.MachineState.OFF;
import static Enums.MachineState.ON;

public class ConversionMachine {
    public MachineState state;

    public void machineStart() {
        this.state = ON;
        ConverterType converterType = ConverterOptionsMenu.showSelectedMenu();

        if (converterType != null) {
            switch (converterType) {
                case MONEY -> this.moneyConverter();
                case TEMPERATURE -> this.temperatureConverter();
            }
        }

        this.state = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0 ? ON : OFF;
    }

    private void moneyConverter() {
        try {
            BigDecimal value = new BigDecimal(JOptionPane.showInputDialog("Enter the value of the money to be converted"));
            MoneyConverter moneyConverter = new MoneyConverter();
            moneyConverter.startCountryCurrencyConversion(value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Enter a correct value");
        }
    }

    private void temperatureConverter() {
        try {
            Double value = Double.parseDouble(JOptionPane.showInputDialog("Enter the value of the temperature to be converted"));
            TemperatureConverter temperatureConverter = new TemperatureConverter();
            temperatureConverter.startTemperatureConversion(value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Enter a correct value");
        }
    }
}
