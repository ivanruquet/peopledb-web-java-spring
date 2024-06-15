package com.ruquet.peopledb_web.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class BigDecimalFormatter implements Formatter<BigDecimal> {

    private final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.JAPAN);

    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        currencyInstance.format(text);
        return new BigDecimal(text);

    }

    @Override
    public String print(BigDecimal object, Locale locale) {
//        return currencyInstance.format(object);
        return NumberFormat.getCurrencyInstance(locale).format(object);
    }
}
