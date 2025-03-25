<!DOCTYPE html>
<html>
<head>
    <style>
        /* CSS for table */
        table {
            width: 90%;
            border-collapse: collapse;
            margin: auto;
            border: 2px solid #ccc; /* Add border */
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        /* CSS for rounded table border */
        .rounded-table {
            border-radius: 15px;
            overflow: hidden;
        }

        /* CSS for main container */
        .main {
            margin-top: 20px;
            text-align: center;
        }
                .top-bar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 24px 16px;
}
.left-content {
    display: flex;
    align-items: center;
}
.navigation {
    display: flex;
    list-style: none;
}
.title {
    margin-right: 48px;
    color: #cd8c38;
    
}
.navigation li {
    margin-right: 36px;
}

.navigation li a:hover {
    color: #cd8c38;
}

.active {
    color: black;
    font-size: 24px;
}
a:hover{
    background-color: white;
    color:#cd8c38
}
    </style>
</head>
<body>
    <%@page import="com.urverse.dao.TicketDao,com.urverse.booking.BookingDetails,java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <jsp:useBean id="u" class="com.urverse.booking.BookingDetails"></jsp:useBean>
    <jsp:setProperty property="*" name="u"/>

    <%
    List<BookingDetails> list = TicketDao.getAllRecords1(u);
    request.setAttribute("list", list);
    %>
        <section class="top-bar">
        <div class="left-content">
            <h1 class="title" style="text-justify: left; font-size: 50px;">Urverse</h1>
            <ul class="navigation">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <li><a class="active" href="movies.jsp" style="color:black;">Home</a></li>
                <li><a class="active" href="concertbooking.html">Concert/Events</a></li>
                <li><a class="active" href="moviebooking.html"  style="color:black;">Movies</a></li>
                <li><a class="active" href="addmovie.html">Add Movies</a></li>
                <li><a class="active" href="viewdetails.jsp">View Details</a></li>
            </ul>
        </section><br><br><br>
        <center>
            <table class="rounded-table" border="1">
                <tr>
                    <th>Booking Id</th>
                    <th>Movie Name</th>
                    <th>Theatre Name</th>
                    <th>Timings</th>
                    <th>Seats Booked</th>
                    <th>Total Price</th>
                </tr>
                <c:forEach items="${list}" var="u">
                    <tr colspan="1">
                        <td>${u.getid()}</td>
                        <td>${u.getmovies()}</td>
                        <td>${u.gettheatres()}</td>
                        <td>${u.gettimings()}</td>
                        <td>${u.getseatsno()}</td>
                        <td>${u.getprice()}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
        </center>
</body>
</html>
