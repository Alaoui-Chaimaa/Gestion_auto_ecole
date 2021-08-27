package com.sid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.entities.Moniteur;
import com.sid.repositories.MoniteurRepository;

@Service
@Transactional
public class MoniteurService {

	@Autowired
    private MoniteurRepository repo;
    
   /* public List<Moniteur> listAll() {
        return repo.findAll();
    }*/
	public List<Moniteur> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
     
    public void save(Moniteur moniteur) {
        repo.save(moniteur);
    }
     
    public Moniteur get(long id) {
        return repo.findById(id);
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
}
