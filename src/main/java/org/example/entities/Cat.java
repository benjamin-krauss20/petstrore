package org.example.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Cat extends Animal implements Serializable {

    private String chipId;

    // --- CONSTRUCTEURS ---
    public Cat() {
    }

    // --- GETTERS ET SETTERS ---
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}