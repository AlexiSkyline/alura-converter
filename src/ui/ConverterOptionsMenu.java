package ui;

import Enums.ConverterType;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

public class ConverterOptionsMenu {
    public static ConverterType showSelectedMenu() {
        Icon alertIcon = UIManager.getIcon("OptionPane.questionIcon");

        String selectedOption = (String) JOptionPane.showInputDialog(null,
                "Select a conversion option", "Converter type",
                JOptionPane.PLAIN_MESSAGE, alertIcon, getAllMessagesOptions().toArray(new String[0]),
                null
        );

        return getEnumSelectedOption(selectedOption);
    }

    private static List<String> getAllMessagesOptions() {
        return Arrays.stream(ConverterType.values())
                .map(ConverterType::getMessage)
                .toList();
    }

    private static ConverterType getEnumSelectedOption(String selected) {
        return Arrays.stream(ConverterType.values())
                .filter(option -> option.getMessage().equals(selected))
                .findFirst()
                .orElse(null);
    }
}
