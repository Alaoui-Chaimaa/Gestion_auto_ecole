package com.sid.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Depense;
import com.sid.entities.Moniteur;

public interface DepenseRepository extends JpaRepository<Depense,Long>{

	Depense save (Depense depense);
	Depense findById(long id);
	List<Depense> findAll();
}
