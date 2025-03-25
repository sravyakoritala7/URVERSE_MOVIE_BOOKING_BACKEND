<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            background-image: url("cine.jpg");
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
    <%@page import="com.urverse.booking.BookingDetails,com.urverse.dao.TicketDao,java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%
        List<BookingDetails> list=TicketDao.getRecordById();
        request.setAttribute("list",list);
        out.println("Data in payment:"+list);
       
        
    %>

    <div class="main">
        <div id="demo"></div><br><br>
        <center>
             
              
            <c:forEach items="${list}" var="u">
                <table>
                    <tr colspan="1">
                        <th>Your Selected Seats:</th>
                        <td><c:out value="${u.seatsno}" /></td>
                    </tr>
                    <tr>
                        <th>Selected Movie:</th>
                        <td><c:out value="${u.movies}" /></td>
                    </tr>
                    <tr>
                        <th>Selected Theatre:</th>
                        <td><c:out value="${u.theatres}" /></td>
                    </tr>
                    <tr>
                        <th>Timings:</th>
                        <td><c:out value="${u.timings}" /></td>
                    </tr>
                     </c:forEach>
                </table>
           
        </center>
    </div>
</body>
