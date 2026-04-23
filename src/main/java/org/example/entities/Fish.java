package org.example.entities;

import org.example.enumeration.FishLivEnv;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
public class Fish extends Animal implements Serializable {

    @Enumerated(EnumType.STRING) // Obligatoire pour stocker le texte de l'enum en base
    private FishLivEnv livingEnv;

    // --- CONSTRUCTEURS ---
    public Fish() {
    }

    // --- GETTERS ET SETTERS ---
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}