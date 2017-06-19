package com.hidroplan.webservice.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hidroplan.service.consolidation.FatorAmbienteService;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteRequest;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteResponse;

@Endpoint
public class FatorAmbienteEndpoint {

	@Autowired
	private FatorAmbienteService service;

	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/createfatorambiente" , localPart = "createFatorAmbienteRequest")
	@ResponsePayload public JAXBElement<CreateFatorAmbienteResponse> createFatorAmbiente(@RequestPayload JAXBElement<CreateFatorAmbienteRequest> createFatorAmbienteRequest) {
		CreateFatorAmbienteResponse responseCreate = service.createFatorAmbiente(createFatorAmbienteRequest.getValue());
		return new com.hidroplan.webservice.model.createfatorambiente.ObjectFactory().createCreateFatorAmbienteResponse(responseCreate);
	}
}
