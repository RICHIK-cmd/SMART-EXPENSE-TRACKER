package storage;

import model.Expense;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static void saveExpense(Expense e) {

        try (FileWriter fw = new FileWriter("src/expenses.csv", true)) {
            fw.write(e.toCSV() + "\n");
            System.out.println("Expense Saved!");
        } catch (IOException ex) {
            System.out.println("Error saving expense.");
        }
    }

    public static void clearFile() {
        try {
            new FileWriter("src/expenses.csv").close();
            System.out.println("All expenses cleared!");
        } catch (IOException e) {
            System.out.println("Error clearing file.");
        }
    }
}