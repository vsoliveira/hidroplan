package com.hidroplan.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidroplan.service.consolidation.FatorAmbienteService;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteRequest;
import com.hidroplan.webservice.model.createfatorambiente.CreateFatorAmbienteResponse;

@Controller
@RequestMapping("/fatorambiente")
public class FatorAmbienteController {

	@Autowired
	private FatorAmbienteService service;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody public CreateFatorAmbienteResponse create(@ModelAttribute CreateFatorAmbienteRequest request) {
		return service.createFatorAmbiente(request);
	}

}
