package model;

public class Expense {

    private String title;
    private double amount;
    private String category;
    private String date;

    public Expense(String title, double amount, String category, String date) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String toCSV() {
        return title + "," + amount + "," + category + "," + date;
    }
}