package com.example.demo.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id ; 
     private int age ; 
     private  String firstName ; 

     private  String lastName; 
     @OneToOne(mappedBy = "etudiant",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
     private Contact contact ; 
     @ManyToMany(mappedBy = "etudiant",cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
     private Set<Role> roles;
     @OneToMany(mappedBy = "etudiant",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE},fetch = FetchType.EAGER )
     private Set<Addresse> addresses;

     

}
