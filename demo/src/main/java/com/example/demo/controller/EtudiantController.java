package com.example.demo.controller;

import com.example.demo.Requests.FisrtNameAndLastNameRequest;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Etudiant;
import com.example.demo.servises.Etudiantservises;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:5173" )

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final Etudiantservises etudiantservises;

    public EtudiantController(Etudiantservises etudiantservises) {
        this.etudiantservises = etudiantservises;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantservises.getAllEtudiant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantservises.findEtudiantById(id);
        if (etudiant == null) {
                throw new ResourceNotFoundException("etudiant not foundd");

        } else {
            return ResponseEntity.ok(etudiant);
        }
    }

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantservises.ajouteEtudiant(etudiant);
        if (newEtudiant != null) {
            return ResponseEntity.ok(newEtudiant);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantservises.modifEtudiant(etudiant, id);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        etudiantservises.deleteEudiiant(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/findByFirstNameAndLastNameWithRB")
    public List<Etudiant> findByFirstNameOrLastName(@RequestBody FisrtNameAndLastNameRequest fisrtNameAndLastNameRequest) {
        return etudiantservises.findByFirstNameOrLastNameWithJPQL(fisrtNameAndLastNameRequest.getFirstName(),fisrtNameAndLastNameRequest.getLastName());
    }

    @GetMapping("/findByTitre/{titre}")
    public List<Etudiant> findByTitre(@PathVariable String titre) {
        return etudiantservises.findByRolesTitre(titre);
    }
    
    
   
}
