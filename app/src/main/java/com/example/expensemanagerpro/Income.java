package com.example.expensemanagerpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Income{
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("name") private String name;
    @Expose
    @SerializedName("amount") private int amount;
    @Expose
    @SerializedName("category") private String category;
    @Expose
    @SerializedName("note") private String note;
    @Expose
    @SerializedName("color") private int color;
    @Expose
    @SerializedName("date") private String date;
    @Expose
    @SerializedName("success") private boolean success;
    @Expose
    @SerializedName("message") private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
