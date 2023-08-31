package com.redmath.bank.Transaction;
import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Transaction {

    @Id
    private Long Transaction_ID;
    private Long Account_ID;

    private java.util.Date Date;
    private String Description;
    private double Amount;
    private String Indicator;

    // Getters and setters
    public Long getTransactionId() {
        return Transaction_ID;
    }

    public void setTransactionId(Long Transaction_ID) {
        this.Transaction_ID = Transaction_ID;
    }




    public Long getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(Long Account_ID) {
        this.Account_ID = Account_ID;
    }
    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getIndicator() {
        return Indicator;
    }

    public void setIndicator(String indicator) {
        this.Indicator = Indicator;
    }



}
