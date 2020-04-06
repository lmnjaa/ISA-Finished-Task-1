package app.kolokvijum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.kolokvijum.dto.NastavniProgramDTO;
import app.kolokvijum.dto.ZadatakDTO;
import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.model.Zadatak;
import app.kolokvijum.service.ZadatakService;

@Controller
@RequestMapping(path="/api/zadaci")
public class ZadatakController {
	

	@Autowired
	private ZadatakService zadatakService;
	
	@RequestMapping(path ="", method = RequestMethod.GET)
	public ResponseEntity<List<ZadatakDTO>> getAllZadaci(){
		List<ZadatakDTO> zadaci = new ArrayList<>();
		
		for(Zadatak z : zadatakService.findAll()) {
			zadaci.add(new ZadatakDTO(z));
		}
		
		return new ResponseEntity<>(zadaci, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ZadatakDTO> getZadatak(@PathVariable("id") Long id){
        Zadatak zadatak = zadatakService.findById(id);
        if(zadatak == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ZadatakDTO zDTO = new ZadatakDTO(zadatak);

        return new ResponseEntity<ZadatakDTO>(zDTO, HttpStatus.OK);

    }
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<ZadatakDTO> store(@RequestBody Zadatak noviZadatak){
        if(zadatakService.findById(noviZadatak.getId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        zadatakService.save(noviZadatak);
        ZadatakDTO noviZadatakDTO = new ZadatakDTO(noviZadatak);
        return new ResponseEntity<ZadatakDTO>(noviZadatakDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ZadatakDTO> update(@PathVariable("id") Long id, @RequestBody Zadatak zad){
    	Zadatak zadatak = zadatakService.findById(id);
        if(zadatak == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        zadatak.setId(zad.getId());
        zadatak.setOblast(zad.getOblast());
        zadatakService.save(zadatak);
        ZadatakDTO zadatakDTO = new ZadatakDTO(zadatak);
        return new ResponseEntity<ZadatakDTO>(zadatakDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ZadatakDTO> delete(@PathVariable("id") Long id){
        Zadatak zadatak = zadatakService.findById(id);
        if(zadatak == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        zadatakService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
