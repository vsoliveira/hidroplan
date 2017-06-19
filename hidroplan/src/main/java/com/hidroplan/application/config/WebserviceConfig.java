package com.hidroplan.application.config;

import java.io.IOException;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import com.hidroplan.utils.Constants;

@EnableWs
@Configuration
public class WebserviceConfig {

	private CommonsXsdSchemaCollection cxsdscEnvironment = new CommonsXsdSchemaCollection();
	private CommonsXsdSchemaCollection cxsdscTaxon = new CommonsXsdSchemaCollection();
	private CommonsXsdSchemaCollection cxsdscSolucaoNutritiva = new CommonsXsdSchemaCollection();
	private CommonsXsdSchemaCollection cxsdscPerfilTaxon = new CommonsXsdSchemaCollection();
	private CommonsXsdSchemaCollection cxsdscFatorAmbiente = new CommonsXsdSchemaCollection();

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, Constants.SERVICES.concat("/*"));
	}

	//ENVIRONMENT SETTINGS START ---------------------------------------------------------------------------------------

	@Bean(name = "environment")
	public DefaultWsdl11Definition environmentWsdl11Definition(XsdSchemaCollection environmentSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("EnvironmentWS");
		definition.setLocationUri(Constants.SERVICES);
		definition.setTargetNamespace("http://hidroplan.com/environment");
		definition.setSchemaCollection(environmentSchema);
		return definition;
	}

	@Bean
	public XsdSchemaCollection environmentSchema() {
		Resource [] res = new Resource [] {
				new ClassPathResource(Constants.XSD.concat("getEnvironment.xsd"))
			};

		cxsdscEnvironment.setInline(true);
		cxsdscEnvironment.setXsds(res);
		return cxsdscEnvironment;
	}

	@Bean
	public PayloadValidatingInterceptor environemntValidatingInterceptor(XsdSchemaCollection environmentSchema) {
		PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
		interceptor.setXsdSchemaCollection(environmentSchema);
		interceptor.setValidateRequest(true);
		interceptor.setValidateResponse(true);

		return interceptor;
	}

	//ENVIRONMENT SETTING END ---------------------------------------------------------------------------------------

	//TAXON SETTINGS START ---------------------------------------------------------------------------------------

	@Bean(name = "taxon")
	public DefaultWsdl11Definition taxonWsdl11Definition(XsdSchemaCollection taxonSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("TaxonWS");
		definition.setLocationUri(Constants.SERVICES);
		definition.setTargetNamespace("http://hidroplan.com/taxon");
		definition.setSchemaCollection(taxonSchema);
		return definition;
	}

	@Bean
	public XsdSchemaCollection taxonSchema() {
		Resource [] res = new Resource [] {
				new ClassPathResource(Constants.XSD.concat("getTaxon.xsd"))
			};

		cxsdscTaxon.setInline(true);
		cxsdscTaxon.setXsds(res);
		return cxsdscTaxon;
	}

	@Bean
	public PayloadValidatingInterceptor taxonValidatingInterceptor(XsdSchemaCollection taxonSchema) {
		PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
		interceptor.setXsdSchemaCollection(taxonSchema);
		interceptor.setValidateRequest(true);
		interceptor.setValidateResponse(true);

		return interceptor;
	}

	//TAXON SETTING END ---------------------------------------------------------------------------------------

	//SOLUCAONUTRITIVA SETTINGS START ---------------------------------------------------------------------------------------

	@Bean(name = "solucaonutritiva")
	public DefaultWsdl11Definition solucaoNutritivaWsdl11Definition(XsdSchemaCollection solucaoNutritivaSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("SolucaNutritivaWS");
		definition.setLocationUri(Constants.SERVICES);
		definition.setTargetNamespace("http://hidroplan.com/solucaonutritiva");
		definition.setSchemaCollection(solucaoNutritivaSchema);
		return definition;
	}

	@Bean
	public XsdSchemaCollection solucaoNutritivaSchema() {
		Resource [] res = new Resource [] {
				new ClassPathResource(Constants.XSD.concat("createSolucaoNutritiva.xsd"))
			};

		cxsdscSolucaoNutritiva.setInline(true);
		cxsdscSolucaoNutritiva.setXsds(res);
		return cxsdscSolucaoNutritiva;
	}

	@Bean
	public PayloadValidatingInterceptor solucaoNutritivaValidatingInterceptor(XsdSchemaCollection solucaoNutritivaSchema) {
		PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
		interceptor.setXsdSchemaCollection(solucaoNutritivaSchema);
		interceptor.setValidateRequest(true);
		interceptor.setValidateResponse(true);

		return interceptor;
	}

	//SOLUCAONUTRITIVA SETTING END ---------------------------------------------------------------------------------------

	//PERFILTAXON SETTINGS START ---------------------------------------------------------------------------------------

		@Bean(name = "perfiltaxon")
		public DefaultWsdl11Definition perfilTaxonWsdl11Definition(XsdSchemaCollection perfilTaxonSchema) {
			DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
			definition.setPortTypeName("PerfilTaxonWS");
			definition.setLocationUri(Constants.SERVICES);
			definition.setTargetNamespace("http://hidroplan.com/perfilTaxon");
			definition.setSchemaCollection(perfilTaxonSchema);
			return definition;
		}

		@Bean
		public XsdSchemaCollection perfilTaxonSchema() {
			Resource [] res = new Resource [] {
					new ClassPathResource(Constants.XSD.concat("createPerfilTaxon.xsd")),
					new ClassPathResource(Constants.XSD.concat("getPerfilTaxon.xsd"))
				};

			cxsdscPerfilTaxon.setInline(true);
			cxsdscPerfilTaxon.setXsds(res);
			return cxsdscPerfilTaxon;
		}

		@Bean
		public PayloadValidatingInterceptor perfilTaxonValidatingInterceptor(XsdSchemaCollection perfilTaxonSchema) {
			PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
			interceptor.setXsdSchemaCollection(perfilTaxonSchema);
			interceptor.setValidateRequest(true);
			interceptor.setValidateResponse(true);

			return interceptor;
		}

		//PERFILTAXON SETTING END ---------------------------------------------------------------------------------------

		//FATORAMBIENTE SETTINGS START ---------------------------------------------------------------------------------------

		@Bean(name = "fatorambiente")
		public DefaultWsdl11Definition fatorAmbienteWsdl11Definition(XsdSchemaCollection fatorAmbienteSchema) {
			DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
			definition.setPortTypeName("FatorAmbienteWS");
			definition.setLocationUri(Constants.SERVICES);
			definition.setTargetNamespace("http://hidroplan.com/fatorambiente");
			definition.setSchemaCollection(fatorAmbienteSchema);
			return definition;
		}

		@Bean
		public XsdSchemaCollection fatorAmbienteSchema() {
			Resource [] res = new Resource [] {
					new ClassPathResource(Constants.XSD.concat("createFatorAmbiente.xsd"))
				};

			cxsdscFatorAmbiente.setInline(true);
			cxsdscFatorAmbiente.setXsds(res);
			return cxsdscFatorAmbiente;
		}

		@Bean
		public PayloadValidatingInterceptor fatorAmbienteValidatingInterceptor(XsdSchemaCollection fatorAmbienteSchema) {
			PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
			interceptor.setXsdSchemaCollection(fatorAmbienteSchema);
			interceptor.setValidateRequest(true);
			interceptor.setValidateResponse(true);

			return interceptor;
		}

		//FATORAMBIENTE SETTING END ---------------------------------------------------------------------------------------

	@Bean
	public CommonsMultipartResolver multipartResolver() throws IOException {
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setDefaultEncoding("utf-8");
	    commonsMultipartResolver.setUploadTempDir(new FileSystemResource("/tmp"));
		commonsMultipartResolver.setMaxUploadSize(50000000);
	    return commonsMultipartResolver;
	}

}
