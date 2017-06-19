SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS solucao_nutritiva_elemento;
DROP TABLE IF EXISTS elementos;
DROP TABLE IF EXISTS fator_ambiente;
DROP TABLE IF EXISTS perfil_taxon;
DROP TABLE IF EXISTS vernacularname;
DROP TABLE IF EXISTS taxon;




/* Create Tables */

CREATE TABLE elementos
(
	id int NOT NULL,
	name varchar(12),
	symbol varchar(3),
	atomic_number int,
	atomic_weight varchar(9),
	density varchar(23),
	melting_point varchar(7),
	boiling_point varchar(7),
	atomic_radius varchar(3),
	covalent_radius varchar(5),
	ionic_radius int,
	specific_volume varchar(5),
	specific_heat varchar(13),
	heat_fusion varchar(13),
	heat_evaporation varchar(13),
	thermal_conductivity varchar(8),
	pauling_electronegativity varchar(4),
	first_ionisation_energy varchar(6),
	oxidation_states varchar(14),
	electronic_configuration varchar(20),
	lattice varchar(3),
	lattice_constant varchar(5),
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE fator_ambiente
(
	id int NOT NULL AUTO_INCREMENT,
	valor decimal(19,4),
	unidade_grandeza varchar(10),
	tipo varchar(255),
	id_perfil_taxon int NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE perfil_taxon
(
	id int NOT NULL AUTO_INCREMENT,
	id_taxon int NOT NULL,
	tipo varchar(255),
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE solucao_nutritiva_elemento
(
	id_perfil_taxon int NOT NULL,
	id_elementos int NOT NULL,
	quantidade_elemento decimal(19,4)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE taxon
(
	id int NOT NULL,
	taxonID int,
	acceptedNameUsageID int,
	parentNameUsageID int,
	originalNameUsageID int,
	scientificName varchar(83),
	acceptedNameUsage varchar(82),
	parentNameUsage varchar(60),
	namePublishedIn varchar(100),
	namePublishedInYear int,
	higherClassification varchar(203),
	phylum varchar(13),
	class int,
	order_taxon varchar(15),
	family varchar(17),
	genus varchar(19),
	specificEpithet varchar(19),
	infraspecificEpithet varchar(17),
	taxonRank varchar(11),
	scientificNameAuthorship varchar(49),
	taxonomicStatus varchar(11),
	nomenclaturalStatus varchar(31),
	modified varchar(26),
	bibliographicCitation varchar(119),
	references_taxon varchar(99),
	PRIMARY KEY (id),
	UNIQUE (id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE vernacularname
(
	id int NOT NULL,
	vernacularName varchar(255),
	language varchar(255),
	locality varchar(255)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;



/* Create Foreign Keys */

ALTER TABLE solucao_nutritiva_elemento
	ADD CONSTRAINT solucao_nutritiva_elemento_ibfk_1 FOREIGN KEY (id_elementos)
	REFERENCES elementos (id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE fator_ambiente
	ADD CONSTRAINT fator_ambiente_ibfk_1 FOREIGN KEY (id_perfil_taxon)
	REFERENCES perfil_taxon (id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE solucao_nutritiva_elemento
	ADD CONSTRAINT solucao_nutritiva_elemento_ibfk_2 FOREIGN KEY (id_perfil_taxon)
	REFERENCES perfil_taxon (id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE perfil_taxon
	ADD FOREIGN KEY (id_taxon)
	REFERENCES taxon (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE vernacularname
	ADD FOREIGN KEY (id)
	REFERENCES taxon (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



