package com.sid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.entities.Depense;
import com.sid.repositories.DepenseRepository;

@Service
@Transactional
public class DepenseService {

	@Autowired
	private DepenseRepository depo;
	public List<Depense> listAll() {
        return depo.findAll();
    }
     
    public void save(Depense depense) {
        depo.save(depense);
    }
     
    public Depense get(long id) {
        return depo.findById(id);
    }
     
    public void delete(long id) {
        depo.deleteById(id);
    }
}
