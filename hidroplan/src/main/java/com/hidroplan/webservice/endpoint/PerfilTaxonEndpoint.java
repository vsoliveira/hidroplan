package com.hidroplan.webservice.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hidroplan.service.consolidation.PerfilTaxonService;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonRequest;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonResponse;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonRequest;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonResponse;

@Endpoint
public class PerfilTaxonEndpoint {

	@Autowired
	private PerfilTaxonService service;

	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/createperfiltaxon", localPart = "createPerfilTaxonRequest")
	@ResponsePayload public JAXBElement<CreatePerfilTaxonResponse> createPerfilTaxon(@RequestPayload JAXBElement<CreatePerfilTaxonRequest> createPerfilTaxonRequest) {
		CreatePerfilTaxonResponse response = service.createPerfilTaxon(createPerfilTaxonRequest.getValue());
		return new com.hidroplan.webservice.model.createperfiltaxon.ObjectFactory().createCreatePerfilTaxonResponse(response);
	}

	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/getperfiltaxon", localPart = "getPerfilTaxonRequest")
	@ResponsePayload public JAXBElement<GetPerfilTaxonResponse> getPerfilTaxon(@RequestPayload JAXBElement<GetPerfilTaxonRequest> getPerfilTaxonRequest) {
		GetPerfilTaxonResponse response = service.getPerfilTaxon(getPerfilTaxonRequest.getValue());
		return new com.hidroplan.webservice.model.getperfiltaxon.ObjectFactory().createGetPerfilTaxonResponse(response);
	}
}
