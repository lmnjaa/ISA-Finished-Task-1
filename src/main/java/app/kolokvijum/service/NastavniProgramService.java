package app.kolokvijum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.repository.NastavniProgramRepository;

@Service
public class NastavniProgramService {
	
	@Autowired
	NastavniProgramRepository nastavniProgramRepository;

	public NastavniProgramService() {
		super();
	}
	
	public Iterable<NastavniProgram> findAll(){
		return nastavniProgramRepository.findAll();
	}
	
	public NastavniProgram findById(Long id) {
		return nastavniProgramRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		nastavniProgramRepository.deleteById(id);
	}
	
	public void save(NastavniProgram nastavniProgram) {
		nastavniProgramRepository.save(nastavniProgram);
	}
	
	
//	public NastavniProgram task(NastavniProgram nastavniProgram) {
//		
//	}

}
