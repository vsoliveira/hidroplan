//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.18 at 12:06:56 AM BRT 
//


package com.hidroplan.webservice.model.createperfiltaxon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hidroplan.webservice.model.createperfiltaxon package. 
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

    private final static QName _CreatePerfilTaxonResponse_QNAME = new QName("http://hidroplan.com/webservice/model/createperfiltaxon", "createPerfilTaxonResponse");
    private final static QName _CreatePerfilTaxonRequest_QNAME = new QName("http://hidroplan.com/webservice/model/createperfiltaxon", "createPerfilTaxonRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hidroplan.webservice.model.createperfiltaxon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreatePerfilTaxonResponse }
     * 
     */
    public CreatePerfilTaxonResponse createCreatePerfilTaxonResponse() {
        return new CreatePerfilTaxonResponse();
    }

    /**
     * Create an instance of {@link CreatePerfilTaxonRequest }
     * 
     */
    public CreatePerfilTaxonRequest createCreatePerfilTaxonRequest() {
        return new CreatePerfilTaxonRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerfilTaxonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/createperfiltaxon", name = "createPerfilTaxonResponse")
    public JAXBElement<CreatePerfilTaxonResponse> createCreatePerfilTaxonResponse(CreatePerfilTaxonResponse value) {
        return new JAXBElement<CreatePerfilTaxonResponse>(_CreatePerfilTaxonResponse_QNAME, CreatePerfilTaxonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerfilTaxonRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hidroplan.com/webservice/model/createperfiltaxon", name = "createPerfilTaxonRequest")
    public JAXBElement<CreatePerfilTaxonRequest> createCreatePerfilTaxonRequest(CreatePerfilTaxonRequest value) {
        return new JAXBElement<CreatePerfilTaxonRequest>(_CreatePerfilTaxonRequest_QNAME, CreatePerfilTaxonRequest.class, null, value);
    }

}
