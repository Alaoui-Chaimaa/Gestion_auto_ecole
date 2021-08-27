package com.sid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.entities.Depense;
import com.sid.entities.Examen;
import com.sid.repositories.ExamenRepository;

@Service
@Transactional
public class ExamenService {

	@Autowired
	private ExamenRepository exao;
	public List<Examen> listAll() {
        return exao.findAll();
    }
     
    public void save(Examen examen) {
        exao.save(examen);
    }
     
    public Examen get(long id) {
        return exao.findById(id);
    }
     
    public void delete(long id) {
       exao.deleteById(id);
    }
}
