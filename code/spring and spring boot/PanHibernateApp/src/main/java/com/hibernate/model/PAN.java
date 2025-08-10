package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pan_table")
public class PAN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String panholderName;
    private String panNumber;

    // Constructors
    public PAN() {}

    public PAN(String panholderName, String panNumber) {
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getPanholderName() {
        return panholderName;
    }

    public void setPanholderName(String panholderName) {
        this.panholderName = panholderName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    @Override
    public String toString() {
        return "PAN [id=" + id + ", panholderName=" + panholderName + ", panNumber=" + panNumber + "]";
    }
}
