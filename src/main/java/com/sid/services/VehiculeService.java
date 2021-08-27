package com.sid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.repositories.VehiculeRepository;
import com.sid.entities.Vehicule;
@Service
@Transactional
public class VehiculeService {

	@Autowired
    private VehiculeRepository repo;
     
    public List<Vehicule> listAll() {
        return repo.findAll();
    }
     
    public void save(Vehicule vehicule) {
        repo.save(vehicule);
    }
     
    public Vehicule get(String matricule) {
        return repo.findByMatricule(matricule);
    }
     
    public void delete(String matricule) {
        repo.deleteByMatricule(matricule);
    }
}
