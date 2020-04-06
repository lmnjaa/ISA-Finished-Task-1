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


import app.kolokvijum.dto.PredmetDTO;
import app.kolokvijum.model.Predmet;
import app.kolokvijum.service.PredmetService;

@Controller
@RequestMapping(path="/api/predmeti")
public class PredmetController {
	
	@Autowired
	private PredmetService predmetService;
	
	@RequestMapping(path ="", method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getAllPredmeti(){
		List<PredmetDTO> predmeti = new ArrayList<>();
		
		for(Predmet p : predmetService.findAll()) {
			predmeti.add(new PredmetDTO(p));
		}
		
		return new ResponseEntity<>(predmeti, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PredmetDTO> getPredmet(@PathVariable("id") Long id){
        Predmet predmet = predmetService.findById(id);
        if(predmet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PredmetDTO predmetDTO = new PredmetDTO(predmet);

        return new ResponseEntity<PredmetDTO>(predmetDTO, HttpStatus.OK);

    }
	
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<PredmetDTO> store(@RequestBody Predmet noviPredmet){
        if(predmetService.findById(noviPredmet.getId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        predmetService.save(noviPredmet);
        PredmetDTO predmetDTO = new PredmetDTO(noviPredmet);
        return new ResponseEntity<PredmetDTO>(predmetDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PredmetDTO> update(@PathVariable("id") Long id, @RequestBody Predmet dobPredmet){
        Predmet predmet = predmetService.findById(id);
        if(predmet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        predmet.setId(dobPredmet.getId());
        predmet.setNaziv(dobPredmet.getNaziv());
        predmetService.save(predmet);
        PredmetDTO nastavnikDTO = new PredmetDTO(predmet);
        return new ResponseEntity<PredmetDTO>(nastavnikDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PredmetDTO> delete(@PathVariable("id") Long id){
        Predmet predmet = predmetService.findById(id);
        if(predmet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        predmetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
