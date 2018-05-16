package com.demianchuk.models;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class Record {

    public enum Type {
        Income, Expense;
    }

    private LocalDate date;
    private Type type;
    private double amount;
    private String category;
    private String note;

    public Record(Type type, LocalDate date, double amount, String category, String note) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public Month getMonth(){
        return date.getMonth();
    }

    public int getYear(){
        return date.getYear();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return type + " " + date + " " + amount + " " + category + " " + note;
    }
}
