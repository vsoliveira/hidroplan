//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.17 at 02:46:39 PM BRT 
//


package com.hidroplan.webservice.model.gettaxon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hidroplan.webservice.model.gettaxon package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTaxonResponse_QNAME = new QName("http://hidroplan.com/webservice/model/gettaxon", "getTaxonResponse");
    private final static QName _GetTaxonRequest_QNAME = new QName("http://hidroplan.com/webservice/model/gettaxon", "getTaxonRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hidroplan.webservice.model.gettaxon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTaxonResponse }
     * 
     */
    public GetTaxonResponse createGetTaxonResponse() {
        return new GetTaxonResponse();
    }

    /**
     * Create an instance of {@link GetTaxonRequest }
     * 
     */
    public GetTaxonRequest createGetTaxonRequest() {
        return new GetTaxonRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaxonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/gettaxon", name = "getTaxonResponse")
    public JAXBElement<GetTaxonResponse> createGetTaxonResponse(GetTaxonResponse value) {
        return new JAXBElement<GetTaxonResponse>(_GetTaxonResponse_QNAME, GetTaxonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaxonRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/gettaxon", name = "getTaxonRequest")
    public JAXBElement<GetTaxonRequest> createGetTaxonRequest(GetTaxonRequest value) {
        return new JAXBElement<GetTaxonRequest>(_GetTaxonRequest_QNAME, GetTaxonRequest.class, null, value);
    }

}
