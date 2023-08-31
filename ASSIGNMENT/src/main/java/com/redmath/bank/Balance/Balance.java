package com.redmath.bank.Balance;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Balance {

//private Long id;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
   // private Account account;

    @Id
    private Long Balance_ID;
    private Long Account_ID;
    private Date date;
    private double Amount;
    private String Indicator;

    // Getters and setters
    public Long getId() {
        return Balance_ID;
    }

    public void setId(Long Balance_ID) {
        this.Balance_ID = Balance_ID;
    }
    public Long getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(Long Account_ID) {
        this.Account_ID = Account_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public String getDbCrIndicator() {
        return Indicator;
    }

    public void setDbCrIndicator(String Indicator) {
        this.Indicator = Indicator;
    }
}
