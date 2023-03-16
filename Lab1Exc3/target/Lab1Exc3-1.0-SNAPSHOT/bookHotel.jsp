<%-- 
    Document   : bookHotel
    Created on : Feb 14, 2023, 12:27:52 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.ArrayList"%>
<%@page import= "business.bookNew" %>
<%@page import= "business.Login" %>
<%@page import= "business.HotelsAvailable" %>
<%@page import= "helper.Hotels" %>
<%@page import= "persistence.hotelsCRUD"%>
<%@page import= "persistence.bookingsCRUD"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Search Hotel 
        </title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly" defer></script>
        <style>
            table.table2 {
            border: 1px dashed #4a4673;
            border-collapse: collapse;
            }
            m{
              color: rgb(28, 30, 54);
              text-align: left;
            } 
        </style>
        <link rel="icon" href="Resources/logo.png" type="image/icon type">        
    </head>
    <body bgcolor="#e9f2ff"><!--For beige #F5F5DC-->

        <table  style="font-family:monospace" font-weight:"900" width="100%">
            <tr>
                <td><img src="Resources/logo.png" width = "150px"></td>
                <td  align="right"><font size="+1"><a href="index.html">Home</a>    |    
                <a href="about.html">About</a>    |    
                Compare    |  
                <% 
                    if (session.getAttribute("username") != null){ 
                %>
                <a href="bookHotel.jsp">Hotel </a>   |   <%}%> 
                Transport    |    
                Contact    |    
                
                <a href= "login.jsp">Login</a></font></td>
            </tr>
        </table>
        <br>
        
        <br>
        
        <m>
            <h2>Hotel? TRAVTEL!</h2>            
        </m>
    <br>
    <form action="Login">
        <table>
            <tr>
                <td>
                   Location: <input type="text" placeholder="Search..">
                </td> 
                <td> 
                    <button type="submit"><i class="fa fa-search"></i></button>
                </td>
            </tr>
        </table>  
      
    </form>
              
    
        <BR>
        <% 
            ArrayList<Hotels> hotelsAvailable = (ArrayList)request.getAttribute("availableHotels");
        %>
        <BR>
        
        <form action="book" method="get">
        <table cellpadding="3">
        <% 
            int i=0;
            for (Hotels hotel: hotelsAvailable){ 
                String hotelName = hotel.getHotelName();
        %>
        <tr>
            <table cellpadding = "10" bgcolor = "white" style="width: 70%">
                <tr> 
                    <td rowspan ="3" width="300px" ><IMG SRC="Resources/hotel(<%= i%>).jpg" width ="250px")></td>
                    <td width="350"><b><h2> <%=hotel.getHotelName()%> </h2></b></td>
                    <td width="250"><%=hotel.getPrice()%>/Night</td>
                    <td rowspan = "3" align="center"><input type="submit" value="Book"><input type="hidden" name="hotel2book" value="<%= hotelName%>"></td>
                </tr>
                <tr width="100">
                    <td><i><%=hotel.getHotelAddress()%></i></td>
                    <td>Rooms Available: <%=hotel.getRoomsAvailable()%> </td>
                </tr>
                <tr width="100">
                    <td colspan = "2">Rating : <%=hotel.getRating()%></td>
                </tr>
            </table>
        </tr>
        <br>
        <%
            i = i+1;
            }
        %>
        </table>
        </form>
        <div id="map"></div>
            <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly"
            defer
          ></script>
        <BR>
        <BR>
        
        <div>
        <marquee behavior="" direction="right">
            <table style="font-family:monospace">
                <tr>
                    <td rowspan="3"><img src="Resources/flowers.png"><img src="Resources/monkey.png" width="50px">
                    <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="30px">
                    <img src="Resources/flowers.png"><img src="Resources/lemur.png" width="50px">
                    <img src="Resources/flowers.png"> </td>
                    <td align = "center" bgcolor="#f2f8ff">Designed by the</td>
                    <td rowspan="3"><img src="Resources/flowers.png"><img src="Resources/penguin.png" width="30px">
                        <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="50px">
                        <img src="Resources/flowers.png"><img src="Resources/monkey.png" width="30px">
                        <img src="Resources/flowers.png"></td>
                </tr>
                <tr align = "center" bgcolor="#f2f8ff">
                    <td>Cast of Madagascar.</td>
                </tr>
                <tr>
                    <td align = "center" bgcolor="#f2f8ff">Run by Humans.</td>
                </tr>
            </table></marquee>

            <table bgcolor="4b548b" width = "100%">
                <tr>
                    <td rowspan = "4"><img src= "Resources/logoDark.png" width = "150px"></td>
                    <td> <font color="white">Follow our Blog </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Instagram </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Twitter </td>
                </tr>
                <tr>
                    <td> <font color="white">Follow us on Facebook </td>
                </tr>
            </table>
        </div>
</body>
</html>
