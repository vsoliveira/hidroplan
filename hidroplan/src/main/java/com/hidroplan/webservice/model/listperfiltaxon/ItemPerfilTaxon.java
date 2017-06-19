//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.06.17 at 04:32:29 PM BRT
//


package com.hidroplan.webservice.model.listperfiltaxon;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.hidroplan.persistence.consolidation.model.base.PerfilTaxon;
import com.hidroplan.persistence.consolidation.model.typing.TypePerfilTaxon;


/**
 * <p>Java class for ItemPerfilTaxon complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ItemPerfilTaxon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPerfilTaxon" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="idTaxon" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPerfilTaxon", propOrder = {
    "idPerfilTaxon",
    "idTaxon",
    "tipo"
})
public class ItemPerfilTaxon {

    @XmlElement(required = true)
    protected BigDecimal idPerfilTaxon;
    @XmlElement(required = true)
    protected BigDecimal idTaxon;
    @XmlElement(required = true)
    protected TypePerfilTaxon tipo;



    public ItemPerfilTaxon() {
		super();
	}

	public ItemPerfilTaxon(PerfilTaxon perfilTaxon) {
		super();
		this.idPerfilTaxon = new BigDecimal(perfilTaxon.getId());
		this.idTaxon = new BigDecimal(perfilTaxon.getTaxon().getId());
		this.tipo = perfilTaxon.getTipo();
	}

	/**
     * Gets the value of the idPerfilTaxon property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdPerfilTaxon() {
        return idPerfilTaxon;
    }

    /**
     * Sets the value of the idPerfilTaxon property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdPerfilTaxon(BigDecimal value) {
        this.idPerfilTaxon = value;
    }

    /**
     * Gets the value of the idTaxon property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdTaxon() {
        return idTaxon;
    }

    /**
     * Sets the value of the idTaxon property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdTaxon(BigDecimal value) {
        this.idTaxon = value;
    }

    /**
     * Gets the value of the tipo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public TypePerfilTaxon getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipo(TypePerfilTaxon value) {
        this.tipo = value;
    }

}