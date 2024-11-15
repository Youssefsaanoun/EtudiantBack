package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

     public List<Etudiant> findByFirstName(String firstName);

    public List<Etudiant> findByFirstNameOrLastName(String firstName, String lastName);
    @Query("SELECT e FROM Etudiant e WHERE e.firstName = ?1 AND e.lastName = ?2")
    public List<Integer>  findByFirstNameOrLastNameWithJPQL(String firstName,String lastName);




    @Query("SELECT e FROM Etudiant e WHERE e.firstName LIKE :myFirstName AND e.lastName  Like :myLastName")
    public List<Etudiant>  findByFirstNameOrLastNameWithJPQLWithNamedParameters(@Param (value="myFirstName")String firstName,@Param (value="myLastName")String lastName);
    public List<Etudiant> findByAgeIn(List<Integer>ages);
    public List<Etudiant> findByRolesTitre(String titre);
}
