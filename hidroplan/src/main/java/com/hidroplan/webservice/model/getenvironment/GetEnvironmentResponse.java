//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.06.18 at 06:29:05 PM BRT
//

package com.hidroplan.webservice.model.getenvironment;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.hidroplan.persistence.consolidation.model.base.FatorAmbiente;
import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.base.SolucaoNutritivaElemento;
import com.hidroplan.persistence.consolidation.model.typing.TypeFatorAmbiente;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;
import com.hidroplan.persistence.consolidation.model.typing.TypeStatusArduino;
import com.hidroplan.webservice.model.listcondicoesambientais.ItemCondicaoAmbiental;
import com.hidroplan.webservice.model.listcondicoesambientais.ListCondicoesAmbientais;
import com.hidroplan.webservice.model.listsolucaonutritiva.ItemElemento;
import com.hidroplan.webservice.model.listsolucaonutritiva.ListSolucaoNutritiva;

/**
 * <p>
 * Java class for GetEnvironmentResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="GetEnvironmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idArduino" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="idTaxonPerfil" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tipoTaxonPerfil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTaxon" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="scientificName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acceptedNameUsage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentNameUsage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listCondicoesAmbientais" type="{http://hidroplan.com/webservice/model/listcondicoesambientais}ListCondicoesAmbientais" minOccurs="0"/>
 *         &lt;element name="listSolucaoNutritiva" type="{http://hidroplan.com/webservice/model/listsolucaonutritiva}ListSolucaoNutritiva" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEnvironmentResponse", propOrder = { "idArduino", "idTaxonPerfil", "tipoTaxonPerfil", "idTaxon",
		"scientificName", "acceptedNameUsage", "parentNameUsage", "listCondicoesAmbientais", "listSolucaoNutritiva" })
public class GetEnvironmentResponse {

	protected BigDecimal idArduino;
	protected BigDecimal idTaxonPerfil;
	protected TypePerfilTaxon tipoTaxonPerfil;
	protected BigDecimal idTaxon;
	protected String scientificName;
	protected String acceptedNameUsage;
	protected String parentNameUsage;
	protected ListCondicoesAmbientais listCondicoesAmbientais;
	protected ListSolucaoNutritiva listSolucaoNutritiva;

	public GetEnvironmentResponse() {
		super();
	}

	public GetEnvironmentResponse(PerfilTaxon perfil, Map<TypeFatorAmbiente, BigDecimal> mapCondicoesAmbientais, Map<String, String> mapSolucaoNutritiva) {
		super();
		this.idArduino = new BigDecimal("0");
		this.idTaxonPerfil = new BigDecimal(perfil.getId());
		this.tipoTaxonPerfil = perfil.getTipo();
		this.idTaxon = new BigDecimal(perfil.getTaxon().getId());
		this.scientificName = perfil.getTaxon().getScientificName();
		this.acceptedNameUsage = perfil.getTaxon().getAcceptedNameUsage();
		this.parentNameUsage = perfil.getTaxon().getParentNameUsage();
		this.listCondicoesAmbientais = defineCondicoesAmbientais(perfil, mapCondicoesAmbientais);
		this.listSolucaoNutritiva = defineSolucaoNutritiva(perfil, mapSolucaoNutritiva);
	}

	private ListCondicoesAmbientais defineCondicoesAmbientais(PerfilTaxon perfil, Map<TypeFatorAmbiente, BigDecimal> mapCondicoesAmbientais) {
		ListCondicoesAmbientais listCondicoesAmbientais = new ListCondicoesAmbientais();

		for (Iterator<FatorAmbiente> solucao = perfil.getFatorAmbientes().iterator(); solucao.hasNext();) {
			ItemCondicaoAmbiental itemResponse = new ItemCondicaoAmbiental();
			FatorAmbiente item = solucao.next();

			BigDecimal valorLido = mapCondicoesAmbientais.get(item.getTipo());
			BigDecimal valorPerfeito = item.getValor();

			if (valorLido.compareTo(valorPerfeito) != 0) {
				if (valorLido.compareTo(valorPerfeito) == -1){
					itemResponse.setStatusArduino(TypeStatusArduino.INCREASE);
					itemResponse.setFatorAmbiental(item.getTipo());
					itemResponse.setGrandeza(item.getValor());
					itemResponse.setUnidadeDeMedida(item.getUnidadeGrandeza());
				} else {
					itemResponse.setStatusArduino(TypeStatusArduino.DECREASE);
					itemResponse.setFatorAmbiental(item.getTipo());
					itemResponse.setGrandeza(item.getValor());
					itemResponse.setUnidadeDeMedida(item.getUnidadeGrandeza());
				}
			} else {
				itemResponse.setStatusArduino(TypeStatusArduino.EQUAL);
				itemResponse.setFatorAmbiental(item.getTipo());
				itemResponse.setGrandeza(item.getValor());
				itemResponse.setUnidadeDeMedida(item.getUnidadeGrandeza());
			}

			itemResponse.setFatorAmbiental(item.getTipo());
			itemResponse.setGrandeza(item.getValor());
			itemResponse.setUnidadeDeMedida(item.getUnidadeGrandeza());

			listCondicoesAmbientais.getItensLista().add(itemResponse);
		}
		return listCondicoesAmbientais;
	}

	private ListSolucaoNutritiva defineSolucaoNutritiva(PerfilTaxon perfil, Map<String, String> mapSolucaoNutritiva) {
		ListSolucaoNutritiva listSolucaoNutritiva = new ListSolucaoNutritiva();

		for (Iterator<SolucaoNutritivaElemento> solucao = perfil.getSolucaoNutritivaElementos().iterator(); solucao
				.hasNext();) {

			ItemElemento itemResponse = new ItemElemento();

			SolucaoNutritivaElemento item = solucao.next();

			BigDecimal valorLido = new BigDecimal(mapSolucaoNutritiva.get(item.getElementos().getSymbol()));
			BigDecimal valorPerfeito = item.getId().getQuantidadeElemento();

			if (valorLido.compareTo(valorPerfeito) != 0) {
				if (valorLido.compareTo(valorPerfeito) == -1){
					itemResponse.setStatusArduino(TypeStatusArduino.INCREASE);
					itemResponse.setSymbolElemento(item.getElementos().getSymbol());
					itemResponse.setNameElemento(item.getElementos().getName());
					itemResponse.setAtomicNumberElemento(new BigDecimal(item.getElementos().getAtomicNumber()));
					itemResponse.setAtomicWeightElemento(item.getElementos().getAtomicWeight());
					itemResponse.setDensityElemento(item.getElementos().getDensity());
					itemResponse.setEletronicConfigurationtElemento(item.getElementos().getElectronicConfiguration());
					itemResponse.setIdElemento(new BigDecimal(item.getElementos().getId()));
					itemResponse.setMolPerL(item.getId().getQuantidadeElemento().toString());
				} else {
					itemResponse.setStatusArduino(TypeStatusArduino.DECREASE);
					itemResponse.setSymbolElemento(item.getElementos().getSymbol());
					itemResponse.setNameElemento(item.getElementos().getName());
					itemResponse.setAtomicNumberElemento(new BigDecimal(item.getElementos().getAtomicNumber()));
					itemResponse.setAtomicWeightElemento(item.getElementos().getAtomicWeight());
					itemResponse.setDensityElemento(item.getElementos().getDensity());
					itemResponse.setEletronicConfigurationtElemento(item.getElementos().getElectronicConfiguration());
					itemResponse.setIdElemento(new BigDecimal(item.getElementos().getId()));
					itemResponse.setMolPerL(item.getId().getQuantidadeElemento().toString());
				}
			} else {
				itemResponse.setStatusArduino(TypeStatusArduino.EQUAL);
				itemResponse.setSymbolElemento(item.getElementos().getSymbol());
				itemResponse.setNameElemento(item.getElementos().getName());
				itemResponse.setAtomicNumberElemento(new BigDecimal(item.getElementos().getAtomicNumber()));
				itemResponse.setAtomicWeightElemento(item.getElementos().getAtomicWeight());
				itemResponse.setDensityElemento(item.getElementos().getDensity());
				itemResponse.setEletronicConfigurationtElemento(item.getElementos().getElectronicConfiguration());
				itemResponse.setIdElemento(new BigDecimal(item.getElementos().getId()));
				itemResponse.setMolPerL(item.getId().getQuantidadeElemento().toString());
			}


			listSolucaoNutritiva.getItensLista().add(itemResponse);
		}
		return listSolucaoNutritiva;
	}

	/**
	 * Gets the value of the idArduino property.
	 *
	 * @return possible object is {@link BigDecimal }
	 *
	 */
	public BigDecimal getIdArduino() {
		return idArduino;
	}

	/**
	 * Sets the value of the idArduino property.
	 *
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 *
	 */
	public void setIdArduino(BigDecimal value) {
		this.idArduino = value;
	}

	/**
	 * Gets the value of the idTaxonPerfil property.
	 *
	 * @return possible object is {@link BigDecimal }
	 *
	 */
	public BigDecimal getIdTaxonPerfil() {
		return idTaxonPerfil;
	}

	/**
	 * Sets the value of the idTaxonPerfil property.
	 *
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 *
	 */
	public void setIdTaxonPerfil(BigDecimal value) {
		this.idTaxonPerfil = value;
	}

	/**
	 * Gets the value of the tipoTaxonPerfil property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public TypePerfilTaxon getTipoTaxonPerfil() {
		return tipoTaxonPerfil;
	}

	/**
	 * Sets the value of the tipoTaxonPerfil property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setTipoTaxonPerfil(TypePerfilTaxon value) {
		this.tipoTaxonPerfil = value;
	}

	/**
	 * Gets the value of the idTaxon property.
	 *
	 * @return possible object is {@link BigDecimal }
	 *
	 */
	public BigDecimal getIdTaxon() {
		return idTaxon;
	}

	/**
	 * Sets the value of the idTaxon property.
	 *
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 *
	 */
	public void setIdTaxon(BigDecimal value) {
		this.idTaxon = value;
	}

	/**
	 * Gets the value of the scientificName property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * Sets the value of the scientificName property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setScientificName(String value) {
		this.scientificName = value;
	}

	/**
	 * Gets the value of the acceptedNameUsage property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getAcceptedNameUsage() {
		return acceptedNameUsage;
	}

	/**
	 * Sets the value of the acceptedNameUsage property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setAcceptedNameUsage(String value) {
		this.acceptedNameUsage = value;
	}

	/**
	 * Gets the value of the parentNameUsage property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getParentNameUsage() {
		return parentNameUsage;
	}

	/**
	 * Sets the value of the parentNameUsage property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setParentNameUsage(String value) {
		this.parentNameUsage = value;
	}

	/**
	 * Gets the value of the listCondicoesAmbientais property.
	 *
	 * @return possible object is {@link ListCondicoesAmbientais }
	 *
	 */
	public ListCondicoesAmbientais getListCondicoesAmbientais() {
		return listCondicoesAmbientais;
	}

	/**
	 * Sets the value of the listCondicoesAmbientais property.
	 *
	 * @param value
	 *            allowed object is {@link ListCondicoesAmbientais }
	 *
	 */
	public void setListCondicoesAmbientais(ListCondicoesAmbientais value) {
		this.listCondicoesAmbientais = value;
	}

	/**
	 * Gets the value of the listSolucaoNutritiva property.
	 *
	 * @return possible object is {@link ListSolucaoNutritiva }
	 *
	 */
	public ListSolucaoNutritiva getListSolucaoNutritiva() {
		return listSolucaoNutritiva;
	}

	/**
	 * Sets the value of the listSolucaoNutritiva property.
	 *
	 * @param value
	 *            allowed object is {@link ListSolucaoNutritiva }
	 *
	 */
	public void setListSolucaoNutritiva(ListSolucaoNutritiva value) {
		this.listSolucaoNutritiva = value;
	}

}
