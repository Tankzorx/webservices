
package com.niceview;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.niceview package. 
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

    private final static QName _GetHotels_QNAME = new QName("http://NiceView.com/", "getHotels");
    private final static QName _CancelHotel_QNAME = new QName("http://NiceView.com/", "cancelHotel");
    private final static QName _GetHotelsResponse_QNAME = new QName("http://NiceView.com/", "getHotelsResponse");
    private final static QName _Exception_QNAME = new QName("http://NiceView.com/", "Exception");
    private final static QName _BookHotelResponse_QNAME = new QName("http://NiceView.com/", "bookHotelResponse");
    private final static QName _CancelHotelResponse_QNAME = new QName("http://NiceView.com/", "cancelHotelResponse");
    private final static QName _BookHotel_QNAME = new QName("http://NiceView.com/", "bookHotel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.niceview
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHotelsResponse }
     * 
     */
    public GetHotelsResponse createGetHotelsResponse() {
        return new GetHotelsResponse();
    }

    /**
     * Create an instance of {@link BookHotel }
     * 
     */
    public BookHotel createBookHotel() {
        return new BookHotel();
    }

    /**
     * Create an instance of {@link GetHotels }
     * 
     */
    public GetHotels createGetHotels() {
        return new GetHotels();
    }

    /**
     * Create an instance of {@link CancelHotelResponse }
     * 
     */
    public CancelHotelResponse createCancelHotelResponse() {
        return new CancelHotelResponse();
    }

    /**
     * Create an instance of {@link CancelHotel }
     * 
     */
    public CancelHotel createCancelHotel() {
        return new CancelHotel();
    }

    /**
     * Create an instance of {@link BookHotelResponse }
     * 
     */
    public BookHotelResponse createBookHotelResponse() {
        return new BookHotelResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DateRange }
     * 
     */
    public DateRange createDateRange() {
        return new DateRange();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link HotelReservation }
     * 
     */
    public HotelReservation createHotelReservation() {
        return new HotelReservation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotels }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "getHotels")
    public JAXBElement<GetHotels> createGetHotels(GetHotels value) {
        return new JAXBElement<GetHotels>(_GetHotels_QNAME, GetHotels.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "cancelHotel")
    public JAXBElement<CancelHotel> createCancelHotel(CancelHotel value) {
        return new JAXBElement<CancelHotel>(_CancelHotel_QNAME, CancelHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "getHotelsResponse")
    public JAXBElement<GetHotelsResponse> createGetHotelsResponse(GetHotelsResponse value) {
        return new JAXBElement<GetHotelsResponse>(_GetHotelsResponse_QNAME, GetHotelsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "bookHotelResponse")
    public JAXBElement<BookHotelResponse> createBookHotelResponse(BookHotelResponse value) {
        return new JAXBElement<BookHotelResponse>(_BookHotelResponse_QNAME, BookHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelHotelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "cancelHotelResponse")
    public JAXBElement<CancelHotelResponse> createCancelHotelResponse(CancelHotelResponse value) {
        return new JAXBElement<CancelHotelResponse>(_CancelHotelResponse_QNAME, CancelHotelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://NiceView.com/", name = "bookHotel")
    public JAXBElement<BookHotel> createBookHotel(BookHotel value) {
        return new JAXBElement<BookHotel>(_BookHotel_QNAME, BookHotel.class, null, value);
    }

}
