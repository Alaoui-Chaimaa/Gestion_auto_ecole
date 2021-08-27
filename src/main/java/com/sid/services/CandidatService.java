package com.sid.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import com.sid.entities.Candidat;
import com.sid.repositories.CandidatRepository;

@Service
@Transactional
public class CandidatService {

	@Autowired
	private CandidatRepository cano;
	public List<Candidat> listCandidats(){
		return  cano.findAll();
	}
	 public void save(Candidat candidat,MultipartFile img) throws IOException{
		
		  String fileName = StringUtils.cleanPath(img.getOriginalFilename());
		  candidat.setPhoto(fileName);
		   
		  Candidat savedUser = cano.save(candidat);

		  String uploadDir = "Candidat-photos/"+savedUser.getId();

		  FileUploadUtil.saveFile(uploadDir, fileName, img);
		   
			  cano.save(savedUser);
			  
		  }
	 public void saveCandidat(Candidat candidat)
	 {
		 cano.save(candidat);
	 }
  public Candidat get(long id) {
      return cano.findById(id).get();
  }
   
  public void delete(long id) {
	cano.deleteById(id);
  } 
  
  public void modifier_facture(int id,double montant_p,double montant_r)
  {
	  
  }
}
