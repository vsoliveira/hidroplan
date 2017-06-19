package com.hidroplan.persistence.consolidation.repository;

import org.springframework.data.repository.CrudRepository;

import com.hidroplan.persistence.consolidation.model.base.Elementos;

public interface ElementosRepository extends CrudRepository<Elementos, Integer>{

	public Elementos findBySymbol (String symbol);

}
