package com.hidroplan.service.consolidation;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.hidroplan.exception.ExecutionInProgressException;
import com.hidroplan.persistence.consolidation.model.base.Taxon;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;
import com.hidroplan.persistence.consolidation.repository.TaxonRepository;
import com.hidroplan.webservice.model.gettaxon.GetTaxonRequest;
import com.hidroplan.webservice.model.gettaxon.GetTaxonResponse;

@Service
@EnableAsync
public class TaxonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaxonService.class);

	@Autowired
	private TaxonRepository taxonRepository;

	public GetTaxonResponse getTaxon(GetTaxonRequest request) throws ExecutionInProgressException{
		Integer idTaxon = defineIdTaxon(request);
		String taxonName = defineTaxonName(request);
		TypePerfilTaxon taxonPerfil = defineTaxonPerfil(request);
		String taxonVernacularName = defineTaxonVernacularName(request);
		Taxon taxon = taxonRepository.findByVernacularnamesIdVernacularNameAndId(taxonVernacularName, idTaxon);
//		Taxon taxon = taxonRepository.findByIdAndAcceptedNameUsageAndVernacularnamesIdVernacularNameAndPerfilTaxonsTipo(idTaxon, taxonName, taxonVernacularName, taxonPerfil);
		if (taxon == null){
			throw new ExecutionInProgressException("Taxon não encontrado!");
		} else {
			return new GetTaxonResponse(taxon);
		}

	}

	public Integer defineIdTaxon(GetTaxonRequest request) {
		return StringUtils.isNotBlank(request.getIdTaxon()) ? new BigDecimal(request.getIdTaxon()).intValue() : null;
	}

	public String defineTaxonName(GetTaxonRequest request) {
		return StringUtils.isNotBlank(request.getTaxonName()) ? request.getTaxonName() : null;
	}

	public TypePerfilTaxon defineTaxonPerfil(GetTaxonRequest request) {
		return request.getTaxonPerfil() != null ? request.getTaxonPerfil() : null;
	}

	public String defineTaxonVernacularName (GetTaxonRequest request){
		if (StringUtils.isNotBlank(request.getTaxonVernacularName())) {

			return request.getTaxonVernacularName();

		} else {
			return null;

		}
	}
}
