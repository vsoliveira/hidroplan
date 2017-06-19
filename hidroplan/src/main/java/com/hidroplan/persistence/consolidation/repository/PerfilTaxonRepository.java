package com.hidroplan.persistence.consolidation.repository;

import org.springframework.data.repository.CrudRepository;

import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;

public interface PerfilTaxonRepository extends CrudRepository<PerfilTaxon, Integer>{

	public PerfilTaxon findByTaxonVernacularnamesIdVernacularNameAndTipo (String vernacularName, String tipo);

	public PerfilTaxon findByTaxonIdAndTipo (Integer id, TypePerfilTaxon tipo);

}
