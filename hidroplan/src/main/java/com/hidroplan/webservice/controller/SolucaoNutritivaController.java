package com.hidroplan.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidroplan.service.consolidation.SolucaoNutritivaService;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaRequest;
import com.hidroplan.webservice.model.createsolucaonutritiva.CreateSolucaoNutritivaResponse;

@Controller
@RequestMapping("/solucaonutritiva")
public class SolucaoNutritivaController {
	@Autowired
	private SolucaoNutritivaService service;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody public CreateSolucaoNutritivaResponse create(@ModelAttribute CreateSolucaoNutritivaRequest request) {
		return service.createSolucaoNutritiva(request);
	}
}
