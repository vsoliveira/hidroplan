//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.17 at 04:32:29 PM BRT 
//


package com.hidroplan.webservice.model.listcondicoesambientais;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListCondicoesAmbientais complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListCondicoesAmbientais">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itensLista" type="{http://hidroplan.com/webservice/model/listcondicoesambientais}ItemCondicaoAmbiental" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListCondicoesAmbientais", propOrder = {
    "itensLista"
})
public class ListCondicoesAmbientais {

    protected List<ItemCondicaoAmbiental> itensLista;

    /**
     * Gets the value of the itensLista property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itensLista property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItensLista().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemCondicaoAmbiental }
     * 
     * 
     */
    public List<ItemCondicaoAmbiental> getItensLista() {
        if (itensLista == null) {
            itensLista = new ArrayList<ItemCondicaoAmbiental>();
        }
        return this.itensLista;
    }

}
