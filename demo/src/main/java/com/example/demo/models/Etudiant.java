package com.example.demo.models;

import java.util.List;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
     private Long id;
 
     private String firstName;
     private String lastName;
     private int age;
 
     @Column(nullable = false, unique = true)
     private String email;
 
     @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Addresse> addresses;
 
     @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Role> roles;
     @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Contact> contacts;


}
