package app.kolokvijum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.kolokvijum.model.Zadatak;
import app.kolokvijum.repository.ZadatakRepository;

@Service
public class ZadatakService {
	
	@Autowired
	ZadatakRepository zadatakRepository;

	public ZadatakService() {
		super();
	}
	
	public Iterable<Zadatak> findAll(){
		return zadatakRepository.findAll();
	}
	
	public Zadatak findById(Long id) {
		return zadatakRepository.findById(id).orElse(null);
	}
	
	public void save(Zadatak zadatak) {
		zadatakRepository.save(zadatak);
	}
	
	public void delete(Long id) {
		zadatakRepository.deleteById(id);
	}

}
