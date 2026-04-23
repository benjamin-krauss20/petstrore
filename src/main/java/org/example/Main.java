package org.example;

import org.example.entities.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Insérer au moins trois enregistrements (Address et PetStore)
        Address a1 = new Address(); a1.setCity("Angers"); a1.setStreet("Rue Pasteur");
        Address a2 = new Address(); a2.setCity("Nantes"); a2.setStreet("Avenue Bretagne");
        Address a3 = new Address(); a3.setCity("Rennes"); a3.setStreet("Place Mairie");
        em.persist(a1); em.persist(a2); em.persist(a3);

        PetStore ps1 = new PetStore(); ps1.setName("Animalis"); ps1.setManagerName("Alice"); ps1.setAddress(a1);
        PetStore ps2 = new PetStore(); ps2.setName("MaxiZoo"); ps2.setManagerName("Bob"); ps2.setAddress(a2);
        PetStore ps3 = new PetStore(); ps3.setName("Zoomalia"); ps3.setManagerName("Charlie"); ps3.setAddress(a3);
        em.persist(ps1); em.persist(ps2); em.persist(ps3);

        // Insérer au moins trois enregistrements (Animaux)
        Cat c1 = new Cat(); c1.setCouleur("Roux"); c1.setBirth(new Date()); c1.setChipId("CHIP-123"); c1.setPetStore(ps1);
        Cat c2 = new Cat(); c2.setCouleur("Noir"); c2.setBirth(new Date()); c2.setChipId("CHIP-456"); c2.setPetStore(ps1);
        Fish f1 = new Fish(); f1.setCouleur("Bleu"); f1.setLivingEnv(FishLivEnv.SEA_WATER); f1.setPetStore(ps2);
        em.persist(c1); em.persist(c2); em.persist(f1);

        // Insérer au moins trois enregistrements (Produits)
        Product p1 = new Product(); p1.setCode("P01"); p1.setLabel("Croquettes Chaton"); p1.setType(ProdType.FOOD); p1.setPrice(15.99); p1.setPetStore(ps1);
        Product p2 = new Product(); p2.setCode("P02"); p2.setLabel("Arbre à chat"); p2.setType(ProdType.ACCESSORY); p2.setPrice(45.50); p2.setPetStore(ps1);
        Product p3 = new Product(); p3.setCode("P03"); p3.setLabel("Filtre Aquarium"); p3.setType(ProdType.CLEANING); p3.setPrice(12.00); p3.setPetStore(ps2);
        em.persist(p1); em.persist(p2); em.persist(p3);

        em.getTransaction().commit();

        // Extraire tous les animaux d'une animalerie donnée
        String magasinCible = "Animalis";
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.name = :name", Animal.class);
        query.setParameter("name", magasinCible);

        List<Animal> animaux = query.getResultList();
        System.out.println("--- Animaux dans le magasin " + magasinCible + " ---");
        for (Animal animal : animaux) {
            System.out.println("ID: " + animal.getId() + " | Couleur: " + animal.getCouleur());
        }

        em.close();
        emf.close();
    }
}
    }
}
