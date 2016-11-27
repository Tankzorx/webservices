/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dtu.mmmngg.GetFlightsResponse;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tankz
 */
public class test2 {
    private final DatatypeFactory df;
    private final CreditCardInfoType creditCardInfo;
    
    public test2() throws DatatypeConfigurationException {
        // Make dates with this.
        df = DatatypeFactory.newInstance();
        creditCardInfo = new CreditCardInfoType();
        creditCardInfo.setName("Bech Camilla");
        creditCardInfo.setNumber("50408822");
        
        CreditCardInfoType.ExpirationDate xp = new CreditCardInfoType.ExpirationDate();
        xp.setMonth(7);
        xp.setYear(9);
        creditCardInfo.setExpirationDate(xp);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAddFlight() {
    System.out.println("testing AddFlight");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("H");
        System.out.println(uid);
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        System.out.println("1");
        String bookingNumber = resp.getReturn().get(0).getBookingNumber();
        XMLGregorianCalendar bookingDate = resp.getReturn().get(0).getDateOfTravel();
        BigInteger price =  BigInteger.valueOf(resp.getReturn().get(0).getPrice());
        
        Boolean status;
        status = addFlight(uid, bookingNumber, bookingDate, price);
        System.out.println("2");
        assertTrue(status);
        
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        getItinerary(uid,flights,hotels);
        System.out.println("3");
        assertEquals(1,flights.value.getFlightInfo().size());
        System.out.println("Booking:");
        System.out.println(flights.value.getFlightInfo().get(0).getBookingNumber());
        // No hotels yet.
        assertNull(hotels.value.getHotelInfo().get(0).getBookingNumber());
        
        assertEquals(price,flights.value.getFlightInfo().get(0).getPrice());
        assertEquals(bookingNumber,flights.value.getFlightInfo().get(0).getBookingNumber());
        
        status = addFlight(uid, bookingNumber, bookingDate, price);
        status = addFlight(uid, bookingNumber, bookingDate, price);
        getItinerary(uid, flights, hotels);
        System.out.println("4");
        // We added 3 flights now!
        assertEquals(3,flights.value.getFlightInfo().size());
        System.out.println("Done with AddFlight");
    }

    private static boolean addFlight(java.lang.String uid, java.lang.String bookingNumber, javax.xml.datatype.XMLGregorianCalendar departure, java.math.BigInteger price) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.addFlight(uid, bookingNumber, departure, price);
    }

    private static void getItinerary(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItinerary(uid, flights, hotels);
    }

    private static String createItinerary(java.lang.String name) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.createItinerary(name);
    }

    private static GetFlightsResponse getFlights(java.lang.String uid, java.lang.String from, java.lang.String to, javax.xml.datatype.XMLGregorianCalendar departureDate) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.getFlights(uid, from, to, departureDate);
    }
}
