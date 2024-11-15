package com.example.demo.servises;

import java.util.List;

import com.example.demo.models.Etudiant;

public interface Etudiantservises {
    public List <Etudiant> getAllEtudiant();
    public void deleteEudiiant(Long id);
    public  Etudiant modifEtudiant(Etudiant etudiant ,long id);
    public Etudiant ajouteEtudiant(Etudiant etudiant);
    public  Etudiant findEtudiantById(Long id);
    List<Etudiant> findByFirstName(String firstName);
    List<Etudiant> findByFirstNameOrLastName(String firstName, String lastName);
    public List<Etudiant> findByFirstNameOrLastNameWithJPQL(String firstName,String lastName);
    public List<Etudiant> findByAgeIn(List<Integer>ages);
    public List<Etudiant> findByRolesTitre(String titre);


}
