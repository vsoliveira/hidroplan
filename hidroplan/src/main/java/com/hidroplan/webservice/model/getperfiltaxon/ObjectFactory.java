//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.18 at 04:38:45 PM BRT 
//


package com.hidroplan.webservice.model.getperfiltaxon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hidroplan.webservice.model.getperfiltaxon package. 
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

    private final static QName _GetPerfilTaxonRequest_QNAME = new QName("http://hidroplan.com/webservice/model/getperfiltaxon", "getPerfilTaxonRequest");
    private final static QName _GetPerfilTaxonResponse_QNAME = new QName("http://hidroplan.com/webservice/model/getperfiltaxon", "getPerfilTaxonResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hidroplan.webservice.model.getperfiltaxon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPerfilTaxonResponse }
     * 
     */
    public GetPerfilTaxonResponse createGetPerfilTaxonResponse() {
        return new GetPerfilTaxonResponse();
    }

    /**
     * Create an instance of {@link GetPerfilTaxonRequest }
     * 
     */
    public GetPerfilTaxonRequest createGetPerfilTaxonRequest() {
        return new GetPerfilTaxonRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerfilTaxonRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/getperfiltaxon", name = "getPerfilTaxonRequest")
    public JAXBElement<GetPerfilTaxonRequest> createGetPerfilTaxonRequest(GetPerfilTaxonRequest value) {
        return new JAXBElement<GetPerfilTaxonRequest>(_GetPerfilTaxonRequest_QNAME, GetPerfilTaxonRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerfilTaxonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/getperfiltaxon", name = "getPerfilTaxonResponse")
    public JAXBElement<GetPerfilTaxonResponse> createGetPerfilTaxonResponse(GetPerfilTaxonResponse value) {
        return new JAXBElement<GetPerfilTaxonResponse>(_GetPerfilTaxonResponse_QNAME, GetPerfilTaxonResponse.class, null, value);
    }

}
