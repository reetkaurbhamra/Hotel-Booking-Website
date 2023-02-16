<%-- 
    Document   : customerBookings
    Created on : Feb 8, 2023, 6:35:26 PM
    Author     : student
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.ArrayList" %>
<%@page import= "com.mycompany.lab1exc3.Bookings" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Your Bookings 
        </title>
        <style>
            table.table2 {
            border: 1px dashed #4a4673;
            border-collapse: collapse;
            }
            m{
              color: rgb(28, 30, 54);
              text-align: left;
            } 
            footer {
                margin-top: auto;
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
                <a href = "bookHotel.jsp">Hotel</a>    |  <%}%>
                Transport    |    
                Contact    |    
                
                <a href= "login.jsp">Login</a></font></td>
            </tr>
        </table>
        <br>
        <br>
        <%
            if (session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
            } 
        %>
        
        Welcome ${username}!!
        
        <br>
        <br>
        
        Your Bookings ->
        
        <% 
            ArrayList<Bookings> custBookings = (ArrayList)request.getAttribute("custBookingsInfo");
        %>
        
        <form action="cancel" method="post">
        <table align="center" bgcolor="#F5F5DC"  cellpadding = "10" border="1" class="table2">

            <tr>
                <th> Hotel Name </th>
                <th> Hotel Address </th>
                <th> Start Date </th>
                <th> End Date </th>
                <th> Cancel Booking </th>
            </tr>
            <% 
               for (Bookings hotel: custBookings){
            %>
            <tr>
                <td> <%=hotel.getHotelName()%> </td>
                <td> <%=hotel.getHotelAddress()%></td>
                <td> <%=new SimpleDateFormat("yyyy-MM-dd").format(hotel.getStartDate())%></td>
                <td> <%=new SimpleDateFormat("yyyy-MM-dd").format(hotel.getEndDate())%></td>
                <% if (hotel.isAvailable()){
                %>
                <td> <input type="submit" value="Cancel" ></td>
                <%}
                else {
                %>
                <td>No Cancellation</td>
                <% }}
                %>
            </tr>
        </table>
        </form>
        <br>
        <br>
        
        <form action="bookNew" method = "get">
            <table align = "center">
                <tr>
                    <td><input type="submit" value="Book Another Hotel"></td>
                </tr>
            </table>
        </form>
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <footer>
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
    </footer>
    </body>
</html>