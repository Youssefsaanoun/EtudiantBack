package com.example.demo.implement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.models.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.servises.Etudiantservises;

@Service
public class EtudiantImplement implements Etudiantservises {

    private final EtudiantRepository etudiantRepository;

    public EtudiantImplement(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant modifEtudiant(Etudiant etudiant, long id) {
        Optional<Etudiant> optional = etudiantRepository.findById(id);
        if (optional.isPresent()) {
            etudiant.setId(id); 
            return etudiantRepository.save(etudiant);
        } else {
            return null;
        }
    }

    @Override
    public Etudiant ajouteEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        Optional<Etudiant> optional = etudiantRepository.findById(id);
        return optional.orElseThrow(()->new NoSuchElementException("id not found"));
    }

    @Override
    public void deleteEudiiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> findByFirstName(String firstName) {
        return etudiantRepository.findByFirstName(firstName);
    }

    @Override
    public List<Etudiant> findByFirstNameOrLastName(String firstName, String lastName) {
        return etudiantRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Etudiant> findByFirstNameOrLastNameWithJPQL(String firstName, String lastName) {
        return etudiantRepository.findByFirstNameOrLastNameWithJPQLWithNamedParameters(firstName, lastName);
    }
    public List<Etudiant> findByAgeIn(List<Integer>ages){
        return etudiantRepository.findByAgeIn(ages);
    }

    @Override
    public List<Etudiant> findByRolesTitre(String titre) {
     return etudiantRepository.findByRolesTitre(titre);
   
    }

}
