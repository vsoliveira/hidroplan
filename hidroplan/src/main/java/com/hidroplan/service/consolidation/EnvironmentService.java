package com.hidroplan.service.consolidation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.typing.TypeFatorAmbiente;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;
import com.hidroplan.persistence.consolidation.repository.PerfilTaxonRepository;
import com.hidroplan.persistence.consolidation.repository.TaxonRepository;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentRequest;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentResponse;
import com.hidroplan.webservice.model.listcondicoesambientais.ItemCondicaoAmbiental;
import com.hidroplan.webservice.model.listsolucaonutritiva.ItemElemento;

@Service
@EnableAsync
public class EnvironmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentService.class);

	@Autowired
	private TaxonRepository taxonRepository;

	@Autowired
	private PerfilTaxonRepository perfilTaxonRepository;

	public GetEnvironmentResponse getEnvironment(GetEnvironmentRequest request) {
		Integer idArduino = defineIdArduino(request);

		Integer idTaxon  = defineIdTaxon(request);
		TypePerfilTaxon taxonPerfil = defineTaxonPerfil(request);

		PerfilTaxon perfilTaxon = perfilTaxonRepository.findByTaxonIdAndTipo(idTaxon, taxonPerfil);

		Map<TypeFatorAmbiente, BigDecimal> mapCondicoesAmbientais = new HashMap<TypeFatorAmbiente, BigDecimal>();
		Map<String, String> mapSolucaoNutritiva = new HashMap<String, String>();

		for (ItemCondicaoAmbiental itemCondicao : request.getListCondicoesAmbientais().getItensLista()) {
			mapCondicoesAmbientais.put(itemCondicao.getFatorAmbiental(), itemCondicao.getGrandeza());
		}

		for (ItemElemento itemElemento : request.getListSolucaoNutritiva().getItensLista()) {
			mapSolucaoNutritiva.put(itemElemento.getSymbolElemento(), itemElemento.getMolPerL());
		}

		return new GetEnvironmentResponse(perfilTaxon, mapCondicoesAmbientais, mapSolucaoNutritiva);
	}
	public Integer defineIdArduino (GetEnvironmentRequest request) {
		return StringUtils.isNotBlank(request.getIdArduino()) ? new BigDecimal(request.getIdArduino()).intValue() : null;
	}

	public Integer defineIdTaxon (GetEnvironmentRequest request) {
		return StringUtils.isNotBlank(request.getIdTaxon()) ? new BigDecimal(request.getIdTaxon()).intValue() : null;
	}

	public TypePerfilTaxon defineTaxonPerfil (GetEnvironmentRequest request) {
		return request.getTipo() != null ? request.getTipo() : null;
	}

}
