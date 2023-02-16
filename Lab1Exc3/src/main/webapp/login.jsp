<%-- 
    Document   : login
    Created on : Feb 7, 2023, 10:52:16 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            TRAVTEL 
        </title>
        <style>
            footer {
                margin-top: auto;
            }
            table.table2 {
            border: 1px dashed #4a4673;
            border-collapse: collapse;
            }
            m{
              color: rgb(28, 30, 54);
              text-align: left;
            } 
            body {
                flex-grow:1;
            }
        </style>
        <link rel="icon" href="Resources/logo.png" type="image/icon type">        
    </head>
    <body bgcolor="#e9f2ff" border = "4"><!--For beige #F5F5DC-->

        <table  style="font-family:monospace" font-weight:"900" width="100%">
            <tr>
                <td><img src="Resources/logo.png" width = "150px"></td>
                <td  align="right"><font size="+1"><a href="index.html">Home</a>    |    
                <a href="about.html">About</a>    |    
                Compare    |    
                <% 
                    if (session.getAttribute("username") != null){ 
                %>
                <a href ="bookHotel.jsp">Hotel</a>    |  
                <%}%>
                <a href = "customerBookings.jsp">Bookings </a>   |    
                Contact    |    
                <a href="login.html">Login</a></font></td>
            </tr>
        </table>
        <BR>
        <BR>
        <form action="Login" method = "get">
            <table align = "center">
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" size=30></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" size=30></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="login"></td>
                </tr>
            </table>
        </form>
        <BR>
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
