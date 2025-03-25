<!DOCTYPE html>

<html>
<head>
 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: url("./images/payment.jpg");
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: cover;
            color: #0e0504;
            font-weight: bold;
            font-family: 'Poppins', sans-serif;
        }

        .main {
            text-align: center;
            font-size: 23px;
            border: 2px solid rgb(226, 218, 196);
            padding: 50px;
            border-radius: 22px;
            box-shadow: 20px 20px 15px #432d27;
            background-color: rgb(226, 218, 196);
            opacity: 0.65;
        }

        table {
            margin: 0 auto;
            font-size: 23px;
        }

        input[type=text],
        input[type=submit] {
            padding: 9px;
            border-radius: 5px;
            font-family: 'Poppins', sans-serif;
        }

        img {
            border-radius: 9px;
        }
    </style>
</head>
<body>

<%@page import="com.urverse.dao.TicketDao,com.urverse.booking.BookingDetails,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="u" class="com.urverse.booking.BookingDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>


<%
List<BookingDetails> list=TicketDao.getAllRecords(u);
request.setAttribute("list",list);

%>
<div class="main">
        <div id="demo"></div><br><br>
        <center>
<table width="90%">
<c:forEach items="${list}" var="u">
     <tr colspan="1">
        <th></th>
         <td><img src="${u.getimage()}" alt="image" width="250px" height="250px"></td> 
    </tr>
     <tr colspan="1">
         <th>Your Selected Seats:</th>
        <td>${u.getseatsno()}</td>
    </tr>
    <tr colspan="1">
        <th>Selected Movie:     </th>
        <td>${u.getmovies()}</td>
    </tr>
    <tr colspan="1">
        <th>Selected Theatre:</th>
        <td>${u.gettheatres()}</td>
    </tr>
    <tr colspan="1">
        <th>Timings:</th>
        <td>${u.gettimings()}</td></tr>
    <tr colspan="1">
        <th>Total Price:</th>
        <td>${u.getprice()}</td></tr>
   
</c:forEach>
</table><br>
            Paid successfully
</center>
</body>
</html>