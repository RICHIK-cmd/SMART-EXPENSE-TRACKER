package service;

import java.io.*;
import java.util.*;

public class Analyzer {

    public static void analyze() {

        Map<String, Double> categoryTotal = new HashMap<>();
        double total = 0;

        String today = java.time.LocalDate.now().toString();

        System.out.println("\n========== TODAY'S EXPENSES ==========");

        try (BufferedReader br = new BufferedReader(new FileReader("src/expenses.csv"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length < 4) continue;

                String title = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2].toLowerCase().trim();
                String date = parts[3];

                if (!date.equals(today)) continue;

                System.out.println(
                        "Title: " + title +
                        " | Amount: ₹" + amount +
                        " | Category: " + category +
                        " | Date: " + date
                );

                total += amount;

                categoryTotal.put(category,
                        categoryTotal.getOrDefault(category, 0.0) + amount);
            }

            System.out.println("\n========== TODAY SUMMARY ==========");
            System.out.println("Total Expense: ₹" + total);

            for (String cat : categoryTotal.keySet()) {
                System.out.println(capitalize(cat) + " → ₹" + categoryTotal.get(cat));
            }

        } catch (IOException e) {
            System.out.println("No expenses found.");
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}