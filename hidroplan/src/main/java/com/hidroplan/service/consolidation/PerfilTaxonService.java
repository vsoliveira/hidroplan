package com.hidroplan.service.consolidation;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;
import com.hidroplan.persistence.consolidation.repository.PerfilTaxonRepository;
import com.hidroplan.persistence.consolidation.repository.TaxonRepository;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonRequest;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonResponse;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonRequest;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonResponse;

@Service
@EnableAsync
public class PerfilTaxonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PerfilTaxonService.class);

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private PerfilTaxonRepository perfilTaxonRepository;

	@Autowired
	private TaxonRepository taxonRepository;

	public GetPerfilTaxonResponse getPerfilTaxon (GetPerfilTaxonRequest request) {

		Integer idTaxon  = defineIdTaxon(request);
		TypePerfilTaxon taxonPerfil = defineTaxonPerfil(request);

		PerfilTaxon perfil = perfilTaxonRepository.findByTaxonIdAndTipo(idTaxon, taxonPerfil);

		return new GetPerfilTaxonResponse(perfil);
	}

	@Transactional
	public CreatePerfilTaxonResponse createPerfilTaxon(final CreatePerfilTaxonRequest request) {
		final CreatePerfilTaxonResponse response = new CreatePerfilTaxonResponse();

		return transactionTemplate.execute(new TransactionCallback<CreatePerfilTaxonResponse>() {
			@Override
			public CreatePerfilTaxonResponse doInTransaction(TransactionStatus transactionStatus) {
				try {

					PerfilTaxon perfilNovo = new PerfilTaxon();
					perfilNovo.setTaxon(taxonRepository.findById(Integer.valueOf(request.getIdTaxon())));
					perfilNovo.setTipo(request.getTipo());


					perfilTaxonRepository.save(perfilNovo);
				} catch (Exception e) {
					LOGGER.info("Erro ao cadastrar perfil: ", e);
					response.setStatus("Perfil Não Cadastrado");
					response.getDetalhes().add(e.toString());
					transactionStatus.setRollbackOnly();
					return response;
				}
				response.setStatus("Solução Cadastrada com Sucesso");
				return response;
			}
		});
	}

	public Integer defineIdTaxon (GetPerfilTaxonRequest request) {
		return StringUtils.isNotBlank(request.getIdTaxon()) ? new BigDecimal(request.getIdTaxon()).intValue() : null;
	}

	public TypePerfilTaxon defineTaxonPerfil(GetPerfilTaxonRequest request) {
		return request.getTipo() != null ? request.getTipo() : null;
	}

}
