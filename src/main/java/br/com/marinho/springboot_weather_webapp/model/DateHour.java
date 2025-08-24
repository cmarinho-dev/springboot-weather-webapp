package br.com.marinho.springboot_weather_webapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateHour {
    private final Locale locale = new Locale("pt", "br");
    private LocalDateTime dateTime;

    public DateHour(int days) {
        dateTime = LocalDateTime.now();
        addDays(days);
    }

    public void addDays(int days) {
        dateTime = dateTime.plusDays(days);
    }

    public String getDayOfWeekMinimal() {
        return dateTime.getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, locale);
    }

    public String getDate() {
        return dateTime.format(
                DateTimeFormatter.ofPattern("E d 'de' MMM", locale)
        );
    }

    public String getHour() {
        return dateTime.format(
                DateTimeFormatter.ofPattern("HH:mm")
        );
    }

    public String getDayOfWeek() {
        return dateTime.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, locale);
    }
}
