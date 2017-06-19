package com.hidroplan.persistence.consolidation.repository;

import org.springframework.data.repository.CrudRepository;

import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.base.Taxon;
import com.hidroplan.persistence.consolidation.model.base.Vernacularname;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;

public interface TaxonRepository extends CrudRepository<Taxon, Integer>{

	public Taxon findById (Integer id);

	public Taxon findByVernacularnamesIdVernacularName (String vernacularName);

	public Taxon findByVernacularnamesIdVernacularNameAndId (String vernacularName, Integer id);

	public Taxon findByVernacularnamesIdVernacularNameAndPerfilTaxonsTipo (String vernacularName, String taxonPerfil);

	public Taxon findByPerfilTaxonsTipo (String taxonPerfil);

	public Taxon findByIdAndAcceptedNameUsage (Integer id, String acceptedNameUsage);

	public Taxon findByIdAndAcceptedNameUsageAndPerfilTaxons (Integer id, String acceptedNameUsage, PerfilTaxon perfilTaxon);

	public Taxon findByIdAndAcceptedNameUsageAndPerfilTaxonsAndVernacularnames (Integer id, String acceptedNameUsage, PerfilTaxon perfilTaxon, Vernacularname vernacularName);

	public Taxon findByIdAndAcceptedNameUsageAndVernacularnamesIdVernacularNameAndPerfilTaxonsTipo(Integer id, String acceptedNameUsage, String vernacularName, TypePerfilTaxon taxonPerfil);


}
