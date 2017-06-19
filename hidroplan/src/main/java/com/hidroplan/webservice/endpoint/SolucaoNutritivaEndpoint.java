package com.hidroplan.webservice.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hidroplan.service.consolidation.SolucaoNutritivaService;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaRequest;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaResponse;

@Endpoint
public class SolucaoNutritivaEndpoint {
	@Autowired
	private SolucaoNutritivaService service;

	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/createsolucaonutritiva" , localPart = "createSolucaNutritivaRequest")
	@ResponsePayload public JAXBElement<CreateSolucaoNutritivaResponse> createSolucaoNutritiva(@RequestPayload JAXBElement<CreateSolucaoNutritivaRequest> createSolucaoNutritivaRequest) {
		CreateSolucaoNutritivaResponse responseCreate = service.createSolucaoNutritiva(createSolucaoNutritivaRequest.getValue());
		return new com.hidroplan.webservice.model.createsolucaonutritiva.ObjectFactory().createCreateSolucaNutritivaResponse(responseCreate);
	}
}
