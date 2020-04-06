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
import app.kolokvijum.dto.PredmetDTO;
import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.model.Predmet;
import app.kolokvijum.service.NastavniProgramService;

@Controller
@RequestMapping(path="/api/nastavni-program")
public class NastavniProgramController {

	
	@Autowired
	private NastavniProgramService nastavniProgramService;
	
	@RequestMapping(path ="", method = RequestMethod.GET)
	public ResponseEntity<List<NastavniProgramDTO>> getAllPrograms(){
		List<NastavniProgramDTO> nastavniProgrami = new ArrayList<>();
		
		for(NastavniProgram p : nastavniProgramService.findAll()) {
			nastavniProgrami.add(new NastavniProgramDTO(p));
		}
		
		return new ResponseEntity<>(nastavniProgrami, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<NastavniProgramDTO> getProgram(@PathVariable("id") Long id){
        NastavniProgram nastavniProgram = nastavniProgramService.findById(id);
        if(nastavniProgram == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NastavniProgramDTO npDTO = new NastavniProgramDTO(nastavniProgram);

        return new ResponseEntity<NastavniProgramDTO>(npDTO, HttpStatus.OK);

    }
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<NastavniProgramDTO> store(@RequestBody NastavniProgram noviProgram){
        if(nastavniProgramService.findById(noviProgram.getId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        nastavniProgramService.save(noviProgram);
        NastavniProgramDTO nastavniProgramDTO = new NastavniProgramDTO(noviProgram);
        return new ResponseEntity<NastavniProgramDTO>(nastavniProgramDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NastavniProgramDTO> update(@PathVariable("id") Long id, @RequestBody NastavniProgram dobNp){
        NastavniProgram np = nastavniProgramService.findById(id);
        if(np == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        np.setId(dobNp.getId());
        np.setNaziv(dobNp.getNaziv());
        nastavniProgramService.save(np);
        NastavniProgramDTO nastavniProgramDTO = new NastavniProgramDTO(np);
        return new ResponseEntity<NastavniProgramDTO>(nastavniProgramDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NastavniProgramDTO> delete(@PathVariable("id") Long id){
        NastavniProgram nastavniProgram = nastavniProgramService.findById(id);
        if(nastavniProgram == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nastavniProgramService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
	
}
