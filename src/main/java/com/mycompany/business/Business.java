/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import com.mycompany.helper.Hotel;
import com.mycompany.helper.HotelsXML;

/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String passwrod) {
        return true;
    }

    public static HotelsXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        //query = "";
        WebTarget searchwebTarget = searchclient.target("http://localhost:8080/searchHotels/webresources/search");
        InputStream is = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        HotelsXML hotels = hotelxmltoObjects(xml);
//        if (token != null) {
//            Client holdclient = ClientBuilder.newClient();
//            WebTarget holdwebTarget = holdclient.target("http://localhost:8080/HoldHotel/webresources/hold/isOnHold");
//            for (Hotel hotel : hotels.getHotels()) {
//
//                InputStream holddata = holdwebTarget.path(hotel.getIsbn()).queryParam("token", token)
//                        .request(MediaType.APPLICATION_XML).get(InputStream.class);
//                try {
//                    Hotel a = hotelholdxmltoObjects(IOUtils.toString(holddata, "utf-8"));
//                    if (a != null)
//                        hotel.setTobeHold(true);
//                    else
//                        hotel.setTobeHold(false);
//                } catch (Exception e) {
//                    hotel.setTobeHold(false);
//                }
//
//            }
        //}

        return (hotels);

    }

    private static HotelsXML hotelxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(HotelsXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            HotelsXML hotels = (HotelsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return hotels;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
