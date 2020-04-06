package app.kolokvijum.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import app.kolokvijum.model.Cas;
import app.kolokvijum.repository.CasRepository;

@Service
public class CasService {
	
	CasRepository casRepository;

	public CasService() {
		super();
	}
	
	public Iterable<Cas> findAll(){
		return casRepository.findAll();
	}
	
	public Cas findById(Long id) {
		return casRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		casRepository.deleteById(id);
	}
	
	public void save(Cas cas) {
		casRepository.save(cas);
	}

}
