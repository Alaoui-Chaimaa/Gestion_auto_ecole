package com.sid.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Examen;

public interface ExamenRepository extends JpaRepository<Examen,Long>{

	Examen save (Examen examen);
	Examen findById(long id);
	List<Examen> findAll();
}
