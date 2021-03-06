//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.06.17 at 02:46:39 PM BRT
//


package com.hidroplan.webservice.model.gettaxon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;


/**
 * <p>Java class for GetTaxonRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetTaxonRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTaxon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxonVernacularName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxonPerfil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTaxonRequest", propOrder = {
    "idTaxon",
    "taxonName",
    "taxonVernacularName",
    "taxonPerfil"
})
public class GetTaxonRequest {

    protected String idTaxon;
    protected String taxonName;
    protected String taxonVernacularName;
    protected TypePerfilTaxon taxonPerfil;

    /**
     * Gets the value of the idTaxon property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdTaxon() {
        return idTaxon;
    }

    /**
     * Sets the value of the idTaxon property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdTaxon(String value) {
        this.idTaxon = value;
    }

    /**
     * Gets the value of the taxonName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaxonName() {
        return taxonName;
    }

    /**
     * Sets the value of the taxonName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxonName(String value) {
        this.taxonName = value;
    }

    /**
     * Gets the value of the taxonVernacularName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaxonVernacularName() {
        return taxonVernacularName;
    }

    /**
     * Sets the value of the taxonVernacularName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxonVernacularName(String value) {
        this.taxonVernacularName = value;
    }

    /**
     * Gets the value of the taxonPerfil property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public TypePerfilTaxon getTaxonPerfil() {
        return taxonPerfil;
    }

    /**
     * Sets the value of the taxonPerfil property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxonPerfil(TypePerfilTaxon value) {
        this.taxonPerfil = value;
    }

}
