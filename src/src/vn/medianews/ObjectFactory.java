
package vn.medianews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vn.medianews package. 
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

    private final static QName _RequestCharacter_QNAME = new QName("http://medianews.vn/", "requestCharacter");
    private final static QName _SubmitCharacterStringArray_QNAME = new QName("http://medianews.vn/", "submitCharacterStringArray");
    private final static QName _SubmitCharacterCharArrayResponse_QNAME = new QName("http://medianews.vn/", "submitCharacterCharArrayResponse");
    private final static QName _SubmitCharacterString_QNAME = new QName("http://medianews.vn/", "submitCharacterString");
    private final static QName _RequestStringResponse_QNAME = new QName("http://medianews.vn/", "requestStringResponse");
    private final static QName _RequestCharacterResponse_QNAME = new QName("http://medianews.vn/", "requestCharacterResponse");
    private final static QName _RequestString_QNAME = new QName("http://medianews.vn/", "requestString");
    private final static QName _SubmitCharacterCharArray_QNAME = new QName("http://medianews.vn/", "submitCharacterCharArray");
    private final static QName _RequestStringArray_QNAME = new QName("http://medianews.vn/", "requestStringArray");
    private final static QName _RequestStringArrayResponse_QNAME = new QName("http://medianews.vn/", "requestStringArrayResponse");
    private final static QName _SubmitCharacterStringArrayResponse_QNAME = new QName("http://medianews.vn/", "submitCharacterStringArrayResponse");
    private final static QName _SubmitCharacterStringResponse_QNAME = new QName("http://medianews.vn/", "submitCharacterStringResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vn.medianews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubmitCharacterStringResponse }
     * 
     */
    public SubmitCharacterStringResponse createSubmitCharacterStringResponse() {
        return new SubmitCharacterStringResponse();
    }

    /**
     * Create an instance of {@link SubmitCharacterStringArrayResponse }
     * 
     */
    public SubmitCharacterStringArrayResponse createSubmitCharacterStringArrayResponse() {
        return new SubmitCharacterStringArrayResponse();
    }

    /**
     * Create an instance of {@link RequestStringArrayResponse }
     * 
     */
    public RequestStringArrayResponse createRequestStringArrayResponse() {
        return new RequestStringArrayResponse();
    }

    /**
     * Create an instance of {@link RequestStringArray }
     * 
     */
    public RequestStringArray createRequestStringArray() {
        return new RequestStringArray();
    }

    /**
     * Create an instance of {@link RequestString }
     * 
     */
    public RequestString createRequestString() {
        return new RequestString();
    }

    /**
     * Create an instance of {@link SubmitCharacterCharArray }
     * 
     */
    public SubmitCharacterCharArray createSubmitCharacterCharArray() {
        return new SubmitCharacterCharArray();
    }

    /**
     * Create an instance of {@link RequestCharacterResponse }
     * 
     */
    public RequestCharacterResponse createRequestCharacterResponse() {
        return new RequestCharacterResponse();
    }

    /**
     * Create an instance of {@link RequestStringResponse }
     * 
     */
    public RequestStringResponse createRequestStringResponse() {
        return new RequestStringResponse();
    }

    /**
     * Create an instance of {@link SubmitCharacterString }
     * 
     */
    public SubmitCharacterString createSubmitCharacterString() {
        return new SubmitCharacterString();
    }

    /**
     * Create an instance of {@link SubmitCharacterCharArrayResponse }
     * 
     */
    public SubmitCharacterCharArrayResponse createSubmitCharacterCharArrayResponse() {
        return new SubmitCharacterCharArrayResponse();
    }

    /**
     * Create an instance of {@link SubmitCharacterStringArray }
     * 
     */
    public SubmitCharacterStringArray createSubmitCharacterStringArray() {
        return new SubmitCharacterStringArray();
    }

    /**
     * Create an instance of {@link RequestCharacter }
     * 
     */
    public RequestCharacter createRequestCharacter() {
        return new RequestCharacter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCharacter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestCharacter")
    public JAXBElement<RequestCharacter> createRequestCharacter(RequestCharacter value) {
        return new JAXBElement<RequestCharacter>(_RequestCharacter_QNAME, RequestCharacter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterStringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterStringArray")
    public JAXBElement<SubmitCharacterStringArray> createSubmitCharacterStringArray(SubmitCharacterStringArray value) {
        return new JAXBElement<SubmitCharacterStringArray>(_SubmitCharacterStringArray_QNAME, SubmitCharacterStringArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterCharArrayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterCharArrayResponse")
    public JAXBElement<SubmitCharacterCharArrayResponse> createSubmitCharacterCharArrayResponse(SubmitCharacterCharArrayResponse value) {
        return new JAXBElement<SubmitCharacterCharArrayResponse>(_SubmitCharacterCharArrayResponse_QNAME, SubmitCharacterCharArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterString")
    public JAXBElement<SubmitCharacterString> createSubmitCharacterString(SubmitCharacterString value) {
        return new JAXBElement<SubmitCharacterString>(_SubmitCharacterString_QNAME, SubmitCharacterString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestStringResponse")
    public JAXBElement<RequestStringResponse> createRequestStringResponse(RequestStringResponse value) {
        return new JAXBElement<RequestStringResponse>(_RequestStringResponse_QNAME, RequestStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCharacterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestCharacterResponse")
    public JAXBElement<RequestCharacterResponse> createRequestCharacterResponse(RequestCharacterResponse value) {
        return new JAXBElement<RequestCharacterResponse>(_RequestCharacterResponse_QNAME, RequestCharacterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestString")
    public JAXBElement<RequestString> createRequestString(RequestString value) {
        return new JAXBElement<RequestString>(_RequestString_QNAME, RequestString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterCharArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterCharArray")
    public JAXBElement<SubmitCharacterCharArray> createSubmitCharacterCharArray(SubmitCharacterCharArray value) {
        return new JAXBElement<SubmitCharacterCharArray>(_SubmitCharacterCharArray_QNAME, SubmitCharacterCharArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStringArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestStringArray")
    public JAXBElement<RequestStringArray> createRequestStringArray(RequestStringArray value) {
        return new JAXBElement<RequestStringArray>(_RequestStringArray_QNAME, RequestStringArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStringArrayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "requestStringArrayResponse")
    public JAXBElement<RequestStringArrayResponse> createRequestStringArrayResponse(RequestStringArrayResponse value) {
        return new JAXBElement<RequestStringArrayResponse>(_RequestStringArrayResponse_QNAME, RequestStringArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterStringArrayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterStringArrayResponse")
    public JAXBElement<SubmitCharacterStringArrayResponse> createSubmitCharacterStringArrayResponse(SubmitCharacterStringArrayResponse value) {
        return new JAXBElement<SubmitCharacterStringArrayResponse>(_SubmitCharacterStringArrayResponse_QNAME, SubmitCharacterStringArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitCharacterStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitCharacterStringResponse")
    public JAXBElement<SubmitCharacterStringResponse> createSubmitCharacterStringResponse(SubmitCharacterStringResponse value) {
        return new JAXBElement<SubmitCharacterStringResponse>(_SubmitCharacterStringResponse_QNAME, SubmitCharacterStringResponse.class, null, value);
    }

}
