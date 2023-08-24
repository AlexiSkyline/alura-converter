package ui;

import Enums.CountryCurrencyType;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class MoneyConverter {
    CountryCurrencyType initTypeValue;
    CountryCurrencyType finalTypeValue;
    BigDecimal value;

    public void startCountryCurrencyConversion(BigDecimal value) {
        this.value = value;
        this.initTypeValue = this.showSelectOptionCountryCurrency("Choose the initial currency:");
        this.finalTypeValue = this.showSelectOptionCountryCurrency("Choose the currency you wish to convert to:");

        if (this.initTypeValue != null && this.finalTypeValue != null)
            this.convertCountryCurrency();
    }

    private CountryCurrencyType showSelectOptionCountryCurrency(String message) {
        Icon alertIcon = UIManager.getIcon("OptionPane.questionIcon");

        String selectedOption = (String) JOptionPane.showInputDialog(
                null,
                message, "Currency type",
                JOptionPane.PLAIN_MESSAGE, alertIcon, this.getAllMessagesOptions().toArray(new String[0]),
                null
        );

        return getEnumSelectedOption(selectedOption);
    }

    private List<String> getAllMessagesOptions() {
        return Arrays.stream(CountryCurrencyType.values())
                .map(CountryCurrencyType::getCountry)
                .filter(message -> this.initTypeValue == null || !message.equals(this.initTypeValue.getCountry()))
                .toList();
    }

    private CountryCurrencyType getEnumSelectedOption(String selected) {
        return Arrays.stream(CountryCurrencyType.values())
                .filter(option -> option.getCountry().equals(selected))
                .findFirst()
                .orElse(null);
    }

    private void convertCountryCurrency() {
        float exchangeRate = this.initTypeValue.getExchangeRates().get(this.finalTypeValue);
        BigDecimal result = this.value.multiply(BigDecimal.valueOf(exchangeRate)).setScale(2, RoundingMode.HALF_UP);
        String message = String.format("%s%s = %s %s", this.value, this.initTypeValue.getSymbol(), result, this.finalTypeValue.getSymbol());
        JOptionPane.showMessageDialog(null, message);
    }
}
