package app.kolokvijum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.kolokvijum.model.Cas;
import app.kolokvijum.model.Predmet;
import app.kolokvijum.model.Zadatak;
import app.kolokvijum.repository.CasRepository;
import app.kolokvijum.repository.PredmetRepository;
import app.kolokvijum.repository.ZadatakRepository;

@Service
public class PredmetService {
	
	@Autowired
	PredmetRepository predmetRepository;
	
	@Autowired
	CasRepository casRepository;
	
	@Autowired
	ZadatakRepository zadatakRepository;

	public PredmetService() {
		super();
	}
	
	public Iterable<Predmet> findAll(){
		return predmetRepository.findAll();
	}
	
	public Predmet findById(Long id) {
		return predmetRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		predmetRepository.deleteById(id);
	}
	
	public void save(Predmet predmet) {
		predmetRepository.save(predmet);
	}
//	
//	public Optional<Predmet> task(Predmet predmet){
//		for(Cas c : casRepository.findAll()) {
//			for(Zadatak z : c.getZadaci()) {
//				if(!predmet.getCasovi()(c) && predmet.getCasovi().contains(z)) {
//					return predmetRepository.findById(predmet.getId());
//				}
//			}
//		}
//		
//		return null;
//	}
}
