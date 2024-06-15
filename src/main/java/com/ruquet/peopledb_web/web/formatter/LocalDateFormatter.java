package com.ruquet.peopledb_web.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class LocalDateFormatter implements Formatter<LocalDate> {


    private final DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, isoLocalDate);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object.format(isoLocalDate);
    }
}
