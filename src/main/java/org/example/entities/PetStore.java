package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String managerName;

    // Relation 1 à 1 avec Address
    @OneToOne
    private Address address;

    // Relation 1 à N avec Product
    @OneToMany(mappedBy = "petStore")
    private List<Product> products;

    // Relation 1 à N avec Animal
    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals;

    // Pensez à générer les Getters et Setters !
}