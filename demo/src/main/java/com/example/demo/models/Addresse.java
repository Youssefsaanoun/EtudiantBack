package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Addresse {
    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String Ville; 
    private int codePostale; 
    @ManyToOne
    private Etudiant etudiant;

}
