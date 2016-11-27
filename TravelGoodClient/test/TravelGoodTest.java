/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dtu.mmmngg.GetFlightsResponse;
import com.niceview.GetHotelsResponse;
import com.niceview.HotelReservation;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;
import travelgoodca.Fault;

/**
 *
 * @author Tankz
 */
public class TravelGoodTest {
    
    DatatypeFactory df;
    CreditCardInfoType creditCardInfo;
    
    public TravelGoodTest() throws DatatypeConfigurationException {
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

    @Test
    public void testCreate() {
        String uid = createItinerary("Hej");
        System.out.println(uid);
        // Can't assert anything here really. The ID differs in length
        // Nice BPEL.
        System.out.println("done with testCreate");
    }
    
    @Test
    public void testCancel() {
        String uid = createItinerary("Hej");
        System.out.println(uid);
        Boolean ok = cancelItinerary(uid);
        assertEquals(ok,true);
        
        // Good test if we implement instant deny for ended sessions
        /*
        Boolean failedOnSubsequentCancel = false;
        try {
            cancelItinerary(uid);
        } catch (Exception e) {
            failedOnSubsequentCancel = true;
        }
        assertTrue(failedOnSubsequentCancel);
        */
        System.out.println("Done with testCancel");
    }
    
    @Test
    public void testGetFlights() throws ParseException {
        System.out.println("testing GetFlights");
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("H");
        System.out.println(uid);
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        
        assertEquals(resp.getReturn().size(),2);
        System.out.println("Done with testGetFlights");
    }
    
    @Test
    public void testGetHotels() {
        System.out.println("testing GetHotels");
        String city = "Copenhagen";
        String uid = createItinerary("aH");
        System.out.println(uid);
        XMLGregorianCalendar dep = df.newXMLGregorianCalendar("2016-12-27");        
        XMLGregorianCalendar arr = df.newXMLGregorianCalendar("2016-12-15");
        
        
        
        GetHotelsResponse resp = getHotels(uid, arr, dep, city);
        
        assertEquals(1,resp.getReturn().size());
        assertEquals(1,resp.getReturn().get(0).getBookingNumber());
        
    }
    
    @Test
    public void testGetItinerary() {
        System.out.println("Testing GetItin");
        String uid = createItinerary("H");
        System.out.println(uid);
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        getItinerary(uid,flights,hotels);
        // Should be empty. Only way to check is to get OutOfBounds exception. Nice
        // 0 index is actually made, because of our initialization. Might give issues
        // Down the road.
        Boolean secondElementExistsFlights = true;
        try {
            flights.value.getFlightInfo().get(1);
        } catch (Exception e) {
            secondElementExistsFlights = false;
        }
        assertFalse(secondElementExistsFlights);
        Boolean secondElementExistsHotels = true;
        try {
            hotels.value.getHotelInfo().get(1).getBookingNumber();
        } catch (Exception e) {
            secondElementExistsHotels = false;
        }
        assertFalse(secondElementExistsHotels);
        System.out.println("Done with getItin");
    }
    
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
    
    @Test
    public void testAddHotel() {
        System.out.println("testing AddHotel");
        String uid = createItinerary("H");
        
        BigInteger price;
        price = BigInteger.valueOf(231);
        BigInteger bookingNumber;
        bookingNumber = BigInteger.valueOf(1);
        
        Boolean ok;
        ok = addHotel(uid, bookingNumber, price);
        assertTrue(ok);
        
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        getItinerary(uid, flights, hotels);
        
        assertEquals(1,hotels.value.getHotelInfo().size());
        assertEquals(hotels.value.getHotelInfo().get(0).getBookingNumber(),bookingNumber);
        assertEquals(hotels.value.getHotelInfo().get(0).getPrice(),price);
        
        ok = addHotel(uid, bookingNumber, price);
        ok = addHotel(uid, bookingNumber, price);
        
        getItinerary(uid, flights, hotels);
        assertEquals(3,hotels.value.getHotelInfo().size());
        System.out.println("Done with testAddHotel");
    }
    
    @Test
    public void testBookItin1() throws Fault {
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("H");
        System.out.println(uid);
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        
        String bookingNumber = resp.getReturn().get(0).getBookingNumber();
        XMLGregorianCalendar bookingDate = resp.getReturn().get(0).getDateOfTravel();
        BigInteger price =  BigInteger.valueOf(resp.getReturn().get(0).getPrice());
        
        Boolean status;
        status = addFlight(uid, bookingNumber, bookingDate, price);
        status = addFlight(uid, bookingNumber, bookingDate, price);
        
        Boolean statusOnBooking;
        
        statusOnBooking = bookItinerary(uid, creditCardInfo);
        
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        System.out.println("Gotcha");
        getItineraryPostPlanning(uid, flights, hotels);
        System.out.println("plz print");
        assertTrue(flights.value.getFlightInfo().get(0).isIsBooked()); 
        assertTrue(flights.value.getFlightInfo().get(1).isIsBooked()); 
    }
    
    @Test
    public void testBookItin2() {
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("H");
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        
        String bookingNumber = resp.getReturn().get(0).getBookingNumber();
        XMLGregorianCalendar bookingDate = resp.getReturn().get(0).getDateOfTravel();
        BigInteger price =  BigInteger.valueOf(resp.getReturn().get(0).getPrice());
        
        Boolean status;
        status = addFlight(uid, "asdjkbdfgklasdfbjkgfkdkfdgm", bookingDate, price);
        
        
        CreditCardInfoType creditCardInfo = new CreditCardInfoType();
        creditCardInfo.setName("Bech Camilla");
        creditCardInfo.setNumber("50408822");
        
        CreditCardInfoType.ExpirationDate xp = new CreditCardInfoType.ExpirationDate();
        xp.setMonth(7);
        xp.setYear(9);
        creditCardInfo.setExpirationDate(xp);
        Boolean statusOnBooking;
        statusOnBooking = true;
        try {
            statusOnBooking = bookItinerary(uid, creditCardInfo);
        } catch (Exception e) {
            statusOnBooking = false;
        }
        System.out.println("Status on Booking that should fail:");
        System.out.println(statusOnBooking);
        assertFalse(statusOnBooking);
        
        
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        if (statusOnBooking) {
            getItineraryPostPlanning(uid, flights, hotels);
        } else {
            getItinerary(uid, flights, hotels);
        }
        
        
        System.out.println(flights.value.getFlightInfo().size());
        
        assertTrue(!flights.value.getFlightInfo().get(0).isIsBooked()); 
    }
    
    @Test
    public void testBookItin3() throws Fault {
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("asdsadH");
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        
        String bookingNumber = resp.getReturn().get(0).getBookingNumber();
        XMLGregorianCalendar bookingDate = resp.getReturn().get(0).getDateOfTravel();
        BigInteger price =  BigInteger.valueOf(resp.getReturn().get(0).getPrice());
        
        Boolean status;
        status = addFlight(uid, "asdjkbdfgklasdfbjkgfkdkfdgm", bookingDate, price);
        status = addFlight(uid, bookingNumber, bookingDate, price);
        
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        getItinerary(uid, flights, hotels);
        System.out.println("Flight list size:");
        System.out.println(flights.value.getFlightInfo().size());
        System.out.println(flights.value.getFlightInfo().get(0).getBookingNumber());
        System.out.println(flights.value.getFlightInfo().get(1).getBookingNumber());
        
        CreditCardInfoType creditCardInfo = new CreditCardInfoType();
        creditCardInfo.setName("Bech Camilla");
        creditCardInfo.setNumber("50408822");
        
        CreditCardInfoType.ExpirationDate xp = new CreditCardInfoType.ExpirationDate();
        xp.setMonth(7);
        xp.setYear(9);
        creditCardInfo.setExpirationDate(xp);
        Boolean statusOnBooking;
        try {
            statusOnBooking = bookItinerary(uid, creditCardInfo);
        } catch (Exception e) {
            statusOnBooking = false;
        }
        
        System.out.println("Booking should have false status:");
        System.out.println(statusOnBooking);
        
        if (statusOnBooking) {
            getItineraryPostPlanning(uid, flights, hotels);
        } else {
            getItinerary(uid, flights, hotels);
        }
        System.out.println("Shouldn't be true:");
        System.out.println(flights.value.getFlightInfo().get(1).isIsBooked());
        assertFalse(flights.value.getFlightInfo().get(0).isIsBooked()); 
        assertFalse(flights.value.getFlightInfo().get(1).isIsBooked()); 
    }
    @Test
    public void testBookItin4() throws Fault {
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("asdsadfgdH");
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights = new javax.xml.ws.Holder<>();
        javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels = new javax.xml.ws.Holder<>();
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        
        
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);        
        String bookingNumber = resp.getReturn().get(0).getBookingNumber();
        XMLGregorianCalendar bookingDate = resp.getReturn().get(0).getDateOfTravel();
        BigInteger price =  BigInteger.valueOf(resp.getReturn().get(0).getPrice());
        
        // Add more flights. 1 legal, 1 illegal.
        Boolean status;
        status = addFlight(uid, bookingNumber, bookingDate, price);
        status = addFlight(uid, "asdjkbdfgklasdfbjkgfkdkfdgm", bookingDate, price);
        getItinerary(uid, flights, hotels);
        System.out.println("Booked?");
        System.out.println(flights.value.getFlightInfo().get(0).isIsBooked());
        //assertTrue(!flights.value.getFlightInfo().get(0).isIsBooked()); 
        
        getItinerary(uid, flights, hotels);
        
        CreditCardInfoType creditCardInfo = new CreditCardInfoType();
        creditCardInfo.setName("Bech Camilla");
        creditCardInfo.setNumber("50408822");
        
        CreditCardInfoType.ExpirationDate xp = new CreditCardInfoType.ExpirationDate();
        xp.setMonth(7);
        xp.setYear(9);
        creditCardInfo.setExpirationDate(xp);
        
        Boolean statusOnBooking; 
        try {
            statusOnBooking = bookItinerary(uid, creditCardInfo);
        } catch (Exception e) {
            statusOnBooking = false;
        }
            
        System.out.println(statusOnBooking);
        
        if (statusOnBooking) {
            getItineraryPostPlanning(uid, flights, hotels);
        } else {
            getItinerary(uid, flights, hotels);
        }
        
        
        // Since the second flight is BAD, nothing should be booked.
        assertFalse(flights.value.getFlightInfo().get(0).isIsBooked()); 
        assertFalse(flights.value.getFlightInfo().get(1).isIsBooked()); 
    }
    
    @Test
    public void testBookItin5() throws Fault {
        String uid = createItinerary("asdsadfgdH");
        Boolean status;
        status = bookItinerary(uid, creditCardInfo);
    }
    /*
    @Test
    public void testCompound1() {
        String fromDestination = "Copenhagen";
        String toDestination = "Amsterdam";
        String uid = createItinerary("H");
        XMLGregorianCalendar travelDate = df.newXMLGregorianCalendar("2016-11-10");
        GetFlightsResponse resp = getFlights(uid,fromDestination, toDestination, travelDate);
        System.out.println(resp.getReturn().size());
        
        Boolean ok = cancelItinerary(uid);
        assertTrue(ok);
    }
    */


    private static String createItinerary(java.lang.String name) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.createItinerary(name);
    }

    private static boolean cancelItinerary(java.lang.String uid) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.cancelItinerary(uid);
    }

    private static GetFlightsResponse getFlights(java.lang.String uid, java.lang.String from, java.lang.String to, javax.xml.datatype.XMLGregorianCalendar departureDate) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.getFlights(uid, from, to, departureDate);
    }


    private static void getItinerary(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItinerary(uid, flights, hotels);
    }

    private static boolean addFlight(java.lang.String uid, java.lang.String bookingNumber, javax.xml.datatype.XMLGregorianCalendar departure, java.math.BigInteger price) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.addFlight(uid, bookingNumber, departure, price);
    }



    private static boolean addHotel(java.lang.String uid, java.math.BigInteger bookingNumber, java.math.BigInteger price) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.addHotel(uid, bookingNumber, price);
    }

    private static GetHotelsResponse getHotels(java.lang.String uid, javax.xml.datatype.XMLGregorianCalendar arrivalDate, javax.xml.datatype.XMLGregorianCalendar departureDate, java.lang.String city) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.getHotels(uid, arrivalDate, departureDate, city);
    }


    private static void getItineraryPostPlanning(java.lang.String uid, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.FlightList> flights, javax.xml.ws.Holder<org.netbeans.j2ee.wsdl.travelgoodbpel.src.travelgoodclient.HotelList> hotels) {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        port.getItineraryPostPlanning(uid, flights, hotels);
    }

    private static boolean bookItinerary(java.lang.String uid, dk.dtu.imm.fastmoney.types.CreditCardInfoType ccInfo) throws Fault {
        travelgoodca.TravelGoodCAService1 service = new travelgoodca.TravelGoodCAService1();
        travelgoodca.TravelGoodClientPortType port = service.getCasaPort1();
        return port.bookItinerary(uid, ccInfo);
    }


}
