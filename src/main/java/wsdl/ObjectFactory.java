
package wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl package. 
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

    private final static QName _CheckSessionResponse_QNAME = new QName("http://service.office.autohome.com/", "checkSessionResponse");
    private final static QName _CheckSession_QNAME = new QName("http://service.office.autohome.com/", "checkSession");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link wsdl.CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link wsdl.CheckSession }
     * 
     */
    public CheckSession createCheckSession() {
        return new CheckSession();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link wsdl.CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.office.autohome.com/", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link wsdl.CheckSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.office.autohome.com/", name = "checkSession")
    public JAXBElement<CheckSession> createCheckSession(CheckSession value) {
        return new JAXBElement<CheckSession>(_CheckSession_QNAME, CheckSession.class, null, value);
    }

}
