package Enums;

import java.util.*;

public enum CountryCurrencyType {
    MEXICO("Mexico", "Peso", "$", new float[]{ 0.059f, 0.054f, 0.046f, 8.51f, 78.19f }),
    USA("United States", "Dollar", "US$", new float[]{ 17.03f, 0.91f, 0.79f, 144.94f, 1332.65f }),
    EUROPE("Europe", "Euro", "€", new float[]{ 18.62f, 1.09f, 0.86f, 158.46f, 1457.78f }),
    UNITED_KINGDOM("United Kingdom", "Pound Sterling", "£", new float[]{ 21.58f, 1.27f, 1.16f, 183.62f, 1697.70f }),
    JAPAN("Japan", "Yen", "¥", new float[]{ 0.12f, 0.0069f, 0.0063f, 0.0054f, 9.20f }),
    SOUTH_KOREA("South Korea", "Won", "₩", new float[]{ 0.013f, 0.00075f, 0.00069f, 1.16f, 0.11f });

    private final String country;
    private final String currency;
    private final String symbol;
    private final float[] exchangeRates;

    CountryCurrencyType(String country, String currency, String symbol, float[] exchangeRates) {
        this.country = country;
        this.currency = currency;
        this.symbol = symbol;
        this.exchangeRates = exchangeRates;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSymbol() {
        return symbol;
    }

    private float[] getExchangeRatesList() {
        return exchangeRates;
    }

    public Map<CountryCurrencyType, Float> getExchangeRates() {
        List<CountryCurrencyType> countryCurrencyTypes = Arrays.asList(CountryCurrencyType.values());
        Map<CountryCurrencyType, Float> exchangeRate = new HashMap<>();

        for (int i = 0, x = 0; i < countryCurrencyTypes.size(); i++) {
            if (countryCurrencyTypes.get(i) != this) {
                exchangeRate.put(countryCurrencyTypes.get(i), this.getExchangeRatesList()[x++]);
            }
        }

        return exchangeRate;
    }
}
