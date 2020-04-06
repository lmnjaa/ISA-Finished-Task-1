package app.kolokvijum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.kolokvijum.dto.CasDTO;
import app.kolokvijum.model.Cas;
import app.kolokvijum.service.CasService;

@Controller
@RequestMapping(path="/api/casovi")
public class CasController {
	
	@Autowired
	private CasService casService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<CasDTO>> getAllCasovi(){
        List<CasDTO> casovi = new ArrayList<>();

        for(Cas n: casService.findAll()){
            casovi.add(new CasDTO(n));
        }
        return new ResponseEntity<>(casovi, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CasDTO> getNastavnik(@PathVariable("id") Long id){
        Cas cas = casService.findById(id);
        if(cas == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CasDTO casDTO = new CasDTO(cas);

        return new ResponseEntity<CasDTO>(casDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<CasDTO> store(@RequestBody Cas noviCas){
        if(casService.findById(noviCas.getId()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        casService.save(noviCas);
        CasDTO casDTO = new CasDTO(noviCas);
        return new ResponseEntity<CasDTO>(casDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CasDTO> update(@PathVariable("id") Long id, @RequestBody Cas dobCas){
        Cas cas = casService.findById(id);
        if(cas == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cas.setId(dobCas.getId());
        cas.setTema(dobCas.getTema());
        casService.save(cas);
        CasDTO casDTO = new CasDTO(cas);
        return new ResponseEntity<CasDTO>(casDTO, HttpStatus.OK);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CasDTO> delete(@PathVariable("id") Long id){
        Cas cas = casService.findById(id);
        if(cas == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        casService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
