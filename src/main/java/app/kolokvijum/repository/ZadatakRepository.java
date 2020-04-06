package app.kolokvijum.repository;

import org.springframework.data.repository.CrudRepository;

import app.kolokvijum.model.Zadatak;

public interface ZadatakRepository extends CrudRepository<Zadatak, Long>{

}
