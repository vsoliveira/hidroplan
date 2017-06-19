package com.hidroplan.service.consolidation;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hidroplan.persistence.consolidation.model.base.Elementos;
import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.base.SolucaoNutritivaElemento;
import com.hidroplan.persistence.consolidation.model.base.SolucaoNutritivaElementoId;
import com.hidroplan.persistence.consolidation.repository.ElementosRepository;
import com.hidroplan.persistence.consolidation.repository.PerfilTaxonRepository;
import com.hidroplan.persistence.consolidation.repository.SolucaoNutritivaElementoRepository;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaRequest;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaResponse;
import com.hidroplan.webservice.model.listsolucaonutritiva.ItemElemento;

@Service
@EnableAsync
public class SolucaoNutritivaService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SolucaoNutritivaService.class);

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private ElementosRepository elementosRepository;

	@Autowired
	private PerfilTaxonRepository perfilTaxonRepository;

	@Autowired
	private SolucaoNutritivaElementoRepository solucaoNutritivaRepository;

	@Transactional
	public CreateSolucaoNutritivaResponse createSolucaoNutritiva(final CreateSolucaoNutritivaRequest request) {
		final CreateSolucaoNutritivaResponse response = new CreateSolucaoNutritivaResponse();

		return transactionTemplate.execute(new TransactionCallback<CreateSolucaoNutritivaResponse>(){
			@Override
			public CreateSolucaoNutritivaResponse doInTransaction(TransactionStatus transactionStatus) {
				try {
					SolucaoNutritivaElemento solucaoNova = new SolucaoNutritivaElemento();
					PerfilTaxon prefilTaxon = perfilTaxonRepository.findByTaxonIdAndTipo(Integer.valueOf(request.getIdTaxon()), request.getTipoTaxonPerfil());

					for (ItemElemento elemento : request.getListSolucaoNutritiva().getItensLista()) {
						SolucaoNutritivaElementoId solucaoNutritivaElementoId = new SolucaoNutritivaElementoId();
						Elementos element = elementosRepository.findBySymbol(elemento.getSymbolElemento());


						solucaoNutritivaElementoId.setIdElementos(element.getId());
						solucaoNutritivaElementoId.setIdPerfilTaxon(prefilTaxon.getId());
						solucaoNutritivaElementoId.setQuantidadeElemento(new BigDecimal(elemento.getMolPerL()));


						solucaoNova.setId(solucaoNutritivaElementoId);

						solucaoNutritivaRepository.save(solucaoNova);
					}

				} catch (Exception e) {
					LOGGER.info("Erro ao cadastrar solução: ", e);
					response.setStatus("Solução Não Cadastrada");
					response.getDetalhes().add(e.toString());
					transactionStatus.setRollbackOnly();
					return response;
				}

				response.setStatus("Solução Cadastrada com Sucesso");
				return response;
			}
		});
	}

}
