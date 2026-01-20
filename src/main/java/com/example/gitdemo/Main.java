package com.example.gitdemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Main {

    static void main() {
        // --- Date and Time Setup ---
        // As per the user's setup, the date is Tuesday, January 20, 2026.
        // For consistency and testing, we'll use a fixed date.
        // To use the actual current date, uncomment the following line and comment out the fixed date:
        // LocalDate today = LocalDate.now();
        LocalDate today = LocalDate.of(2026, 1, 20);

        // --- Data Extraction ---
        String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
        String date = today.format(DateTimeFormatter.ofPattern("dd MMM yyyy")).toUpperCase();
        int weekNumber = today.get(WeekFields.of(Locale.ENGLISH).weekOfWeekBasedYear());
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();

        // --- Formatting and Printing ---
        String topDateLine = String.format("     %s, %s       ", dayOfWeek, date);
        String bottomInfoLine = String.format("   Week: %02d | Month: %s   ", weekNumber, monthName);

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║" + topDateLine + "║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║" + bottomInfoLine + "║");
        System.out.println("╚════════════════════════════════╝");
    }
}
