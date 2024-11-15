package com.example.demo.models;



import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    private int id ; 
    private String titre ; 
    @ManyToOne
    private Etudiant etudiant;


}
