package com.sid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.entities.Candidat;


public interface CandidatRepository extends JpaRepository<Candidat,Long>{
	
	@Query("update Candidat c set c.montant_paye=montant_p,c.montant_reste=montant_r where c.id=id")
	public void modifier_facture(@Param("id") int id,@Param("montant_paye") double montant_p,@Param("montant_reste") double motant_r);
}
