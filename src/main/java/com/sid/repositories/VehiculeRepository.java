package com.sid.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule,String> {

	Vehicule findByMatricule(String matricule);

	void deleteByMatricule(String matricule);

}
