package com.sid.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sid.entities.Moniteur;
import com.sid.entities.Vehicule;


public interface MoniteurRepository extends JpaRepository<Moniteur,Long>{
  
	Moniteur save(Moniteur moniteur);
	Moniteur findById(long id);
	List<Moniteur> findAll();
	@Query("SELECT m FROM Moniteur m WHERE CONCAT(m.cap, ' ', m.cin, ' ', m.nom, ' ', m.telephone, ' ', m.type, ' ', m.adresse, ' ', m.numero_permis) LIKE %?1%")
	public List<Moniteur> search(String keyword);
	
}
