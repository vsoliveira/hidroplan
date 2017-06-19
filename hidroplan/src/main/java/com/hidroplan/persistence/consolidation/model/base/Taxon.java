package com.hidroplan.persistence.consolidation.model.base;
// Generated 16/06/2017 21:45:16 by Hibernate Tools 5.2.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Taxon generated by hbm2java
 */
@Entity
@Table(name = "taxon", catalog = "hidroplan")
public class Taxon implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 771532047622754070L;
	private int id;
	private Integer taxonId;
	private Integer acceptedNameUsageId;
	private Integer parentNameUsageId;
	private Integer originalNameUsageId;
	private String scientificName;
	private String acceptedNameUsage;
	private String parentNameUsage;
	private String namePublishedIn;
	private Integer namePublishedInYear;
	private String higherClassification;
	private String phylum;
	private Integer class_;
	private String orderTaxon;
	private String family;
	private String genus;
	private String specificEpithet;
	private String infraspecificEpithet;
	private String taxonRank;
	private String scientificNameAuthorship;
	private String taxonomicStatus;
	private String nomenclaturalStatus;
	private String modified;
	private String bibliographicCitation;
	private String referencesTaxon;
	private List<Vernacularname> vernacularnames = new ArrayList<Vernacularname>(0);
	private List<PerfilTaxon> perfilTaxons = new ArrayList<PerfilTaxon>(0);

	public Taxon() {
	}

	public Taxon(int id) {
		this.id = id;
	}

	public Taxon(int id, Integer taxonId, Integer acceptedNameUsageId, Integer parentNameUsageId,
			Integer originalNameUsageId, String scientificName, String acceptedNameUsage, String parentNameUsage,
			String namePublishedIn, Integer namePublishedInYear, String higherClassification, String phylum,
			Integer class_, String orderTaxon, String family, String genus, String specificEpithet,
			String infraspecificEpithet, String taxonRank, String scientificNameAuthorship, String taxonomicStatus,
			String nomenclaturalStatus, String modified, String bibliographicCitation, String referencesTaxon,
			List<Vernacularname> vernacularnames, List<PerfilTaxon> perfilTaxons) {
		this.id = id;
		this.taxonId = taxonId;
		this.acceptedNameUsageId = acceptedNameUsageId;
		this.parentNameUsageId = parentNameUsageId;
		this.originalNameUsageId = originalNameUsageId;
		this.scientificName = scientificName;
		this.acceptedNameUsage = acceptedNameUsage;
		this.parentNameUsage = parentNameUsage;
		this.namePublishedIn = namePublishedIn;
		this.namePublishedInYear = namePublishedInYear;
		this.higherClassification = higherClassification;
		this.phylum = phylum;
		this.class_ = class_;
		this.orderTaxon = orderTaxon;
		this.family = family;
		this.genus = genus;
		this.specificEpithet = specificEpithet;
		this.infraspecificEpithet = infraspecificEpithet;
		this.taxonRank = taxonRank;
		this.scientificNameAuthorship = scientificNameAuthorship;
		this.taxonomicStatus = taxonomicStatus;
		this.nomenclaturalStatus = nomenclaturalStatus;
		this.modified = modified;
		this.bibliographicCitation = bibliographicCitation;
		this.referencesTaxon = referencesTaxon;
		this.vernacularnames = vernacularnames;
		this.perfilTaxons = perfilTaxons;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "taxonID")
	public Integer getTaxonId() {
		return this.taxonId;
	}

	public void setTaxonId(Integer taxonId) {
		this.taxonId = taxonId;
	}

	@Column(name = "acceptedNameUsageID")
	public Integer getAcceptedNameUsageId() {
		return this.acceptedNameUsageId;
	}

	public void setAcceptedNameUsageId(Integer acceptedNameUsageId) {
		this.acceptedNameUsageId = acceptedNameUsageId;
	}

	@Column(name = "parentNameUsageID")
	public Integer getParentNameUsageId() {
		return this.parentNameUsageId;
	}

	public void setParentNameUsageId(Integer parentNameUsageId) {
		this.parentNameUsageId = parentNameUsageId;
	}

	@Column(name = "originalNameUsageID")
	public Integer getOriginalNameUsageId() {
		return this.originalNameUsageId;
	}

	public void setOriginalNameUsageId(Integer originalNameUsageId) {
		this.originalNameUsageId = originalNameUsageId;
	}

	@Column(name = "scientificName", length = 83)
	public String getScientificName() {
		return this.scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	@Column(name = "acceptedNameUsage", length = 82)
	public String getAcceptedNameUsage() {
		return this.acceptedNameUsage;
	}

	public void setAcceptedNameUsage(String acceptedNameUsage) {
		this.acceptedNameUsage = acceptedNameUsage;
	}

	@Column(name = "parentNameUsage", length = 60)
	public String getParentNameUsage() {
		return this.parentNameUsage;
	}

	public void setParentNameUsage(String parentNameUsage) {
		this.parentNameUsage = parentNameUsage;
	}

	@Column(name = "namePublishedIn", length = 100)
	public String getNamePublishedIn() {
		return this.namePublishedIn;
	}

	public void setNamePublishedIn(String namePublishedIn) {
		this.namePublishedIn = namePublishedIn;
	}

	@Column(name = "namePublishedInYear")
	public Integer getNamePublishedInYear() {
		return this.namePublishedInYear;
	}

	public void setNamePublishedInYear(Integer namePublishedInYear) {
		this.namePublishedInYear = namePublishedInYear;
	}

	@Column(name = "higherClassification", length = 203)
	public String getHigherClassification() {
		return this.higherClassification;
	}

	public void setHigherClassification(String higherClassification) {
		this.higherClassification = higherClassification;
	}

	@Column(name = "phylum", length = 13)
	public String getPhylum() {
		return this.phylum;
	}

	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}

	@Column(name = "class")
	public Integer getClass_() {
		return this.class_;
	}

	public void setClass_(Integer class_) {
		this.class_ = class_;
	}

	@Column(name = "order_taxon", length = 15)
	public String getOrderTaxon() {
		return this.orderTaxon;
	}

	public void setOrderTaxon(String orderTaxon) {
		this.orderTaxon = orderTaxon;
	}

	@Column(name = "family", length = 17)
	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "genus", length = 19)
	public String getGenus() {
		return this.genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	@Column(name = "specificEpithet", length = 19)
	public String getSpecificEpithet() {
		return this.specificEpithet;
	}

	public void setSpecificEpithet(String specificEpithet) {
		this.specificEpithet = specificEpithet;
	}

	@Column(name = "infraspecificEpithet", length = 17)
	public String getInfraspecificEpithet() {
		return this.infraspecificEpithet;
	}

	public void setInfraspecificEpithet(String infraspecificEpithet) {
		this.infraspecificEpithet = infraspecificEpithet;
	}

	@Column(name = "taxonRank", length = 11)
	public String getTaxonRank() {
		return this.taxonRank;
	}

	public void setTaxonRank(String taxonRank) {
		this.taxonRank = taxonRank;
	}

	@Column(name = "scientificNameAuthorship", length = 49)
	public String getScientificNameAuthorship() {
		return this.scientificNameAuthorship;
	}

	public void setScientificNameAuthorship(String scientificNameAuthorship) {
		this.scientificNameAuthorship = scientificNameAuthorship;
	}

	@Column(name = "taxonomicStatus", length = 11)
	public String getTaxonomicStatus() {
		return this.taxonomicStatus;
	}

	public void setTaxonomicStatus(String taxonomicStatus) {
		this.taxonomicStatus = taxonomicStatus;
	}

	@Column(name = "nomenclaturalStatus", length = 31)
	public String getNomenclaturalStatus() {
		return this.nomenclaturalStatus;
	}

	public void setNomenclaturalStatus(String nomenclaturalStatus) {
		this.nomenclaturalStatus = nomenclaturalStatus;
	}

	@Column(name = "modified", length = 26)
	public String getModified() {
		return this.modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	@Column(name = "bibliographicCitation", length = 119)
	public String getBibliographicCitation() {
		return this.bibliographicCitation;
	}

	public void setBibliographicCitation(String bibliographicCitation) {
		this.bibliographicCitation = bibliographicCitation;
	}

	@Column(name = "references_taxon", length = 99)
	public String getReferencesTaxon() {
		return this.referencesTaxon;
	}

	public void setReferencesTaxon(String referencesTaxon) {
		this.referencesTaxon = referencesTaxon;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxon")
	public List<Vernacularname> getVernacularnames() {
		return this.vernacularnames;
	}

	public void setVernacularnames(List<Vernacularname> vernacularnames) {
		this.vernacularnames = vernacularnames;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxon")
	public List<PerfilTaxon> getPerfilTaxons() {
		return this.perfilTaxons;
	}

	public void setPerfilTaxons(List<PerfilTaxon> perfilTaxons) {
		this.perfilTaxons = perfilTaxons;
	}

}
