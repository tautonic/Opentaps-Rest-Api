//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.08 at 03:11:15 PM CET 
//


package org.opentaps.module.ws.rest.domain.response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.opentaps.module.ws.rest.domain.response package. 
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

    private final static QName _Response_QNAME = new QName("http://www.opentaps.org/module/ws/rest/domain/response", "Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.opentaps.module.ws.rest.domain.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResponseBean }
     * 
     */
    public ResponseBean createResponseBean() {
        return new ResponseBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentaps.org/module/ws/rest/domain/response", name = "Response")
    public JAXBElement<ResponseBean> createResponse(ResponseBean value) {
        return new JAXBElement<ResponseBean>(_Response_QNAME, ResponseBean.class, null, value);
    }

}
