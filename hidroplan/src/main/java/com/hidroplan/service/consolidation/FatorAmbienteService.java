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

import com.hidroplan.persistence.consolidation.model.base.FatorAmbiente;
import com.hidroplan.persistence.consolidation.repository.FatorAmbienteRepository;
import com.hidroplan.persistence.consolidation.repository.PerfilTaxonRepository;
import com.hidroplan.persistence.consolidation.repository.TaxonRepository;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteRequest;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteResponse;

@Service
@EnableAsync
public class FatorAmbienteService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FatorAmbienteService.class);

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private FatorAmbienteRepository fatorAmbienteRepository;

	@Autowired
	private TaxonRepository taxonRepository;

	@Autowired
	private PerfilTaxonRepository perfilTaxonRepository;

	@Transactional
	public CreateFatorAmbienteResponse createFatorAmbiente(final CreateFatorAmbienteRequest request) {
		final CreateFatorAmbienteResponse response = new CreateFatorAmbienteResponse();

		return transactionTemplate.execute(new TransactionCallback<CreateFatorAmbienteResponse>(){
			@Override
			public CreateFatorAmbienteResponse doInTransaction(TransactionStatus transactionStatus) {
				try {

					FatorAmbiente fatorNovo = new FatorAmbiente();
					fatorNovo.setPerfilTaxon(perfilTaxonRepository.findByTaxonIdAndTipo(Integer.valueOf(request.getIdTaxon()), request.getTipoTaxonPerfil()));
					fatorNovo.setTipo(request.getTipoFatorAmbiente());
					fatorNovo.setUnidadeGrandeza(request.getUnidadeDoValorFatorAmbiente());
					fatorNovo.setValor(new BigDecimal(request.getValorFatorAmbiente()));

					fatorAmbienteRepository.save(fatorNovo);

				} catch (Exception e) {
					LOGGER.info("Erro ao cadastrar fator: ", e);
					response.setStatus("Fator Não Cadastrado");
					response.getDetalhes().add(e.toString());
					transactionStatus.setRollbackOnly();
					return response;
				}

				response.setStatus("Fator Cadastrado com Sucesso");
				return response;
			}
		});
	}
}
