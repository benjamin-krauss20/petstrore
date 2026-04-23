package org.example.entities;

import org.example.enumeration.ProdType;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private double price;

    // Relation N à 1 vers PetStore
    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

}