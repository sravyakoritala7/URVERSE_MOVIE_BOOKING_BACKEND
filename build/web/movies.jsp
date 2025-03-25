<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"></head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="movie.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
   <link href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap" rel="stylesheet">
    <title>View Users</title>
    <style>
           body{
            background: linear-gradient(
                to right,
                rgb(0, 0, 0) 0%,
                rgb(21, 17, 17) 46%,
                white 46%,
                white 100%
            );
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
    margin-right: 16px;
}

.navigation li a:hover {
    color: #cd8c38;
}

.active {
    color: black;
}
a:hover{
    background-color: white;
    color:#cd8c38
}

    </style>
</head>
<body>

 <section class="top-bar">
        <div class="left-content">
            <h1 class="title" style="text-justify: left; font-size: 45px;">Urverse</h1>
            <ul class="navigation">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <li><a href="movies.jsp" style="color:black;">Home</a></li>
                <li><a class="active" href="concertbooking.html">Concert/Events</a></li>
                <li><a href="moviebooking.html"  style="color:black;">Movies</a></li>
            </ul>
    </section>
     <div class="space">
        <p></p>
    </div>
    <div class="title">
        <marquee behavior="" direction=""><h1 style="color:#cd8c38; font-family: 'Playfair Display', serif;text-decoration: dashed;"><a href="" style="color:#cd8c38;">LATEST  UPDATES</a></h1></marquee>
    </div>
    <div class="space">
        <p></p>
    </div>
    <%@page import="com.urverse.movies.MovieDetails,com.urverse.mdao.MovieDao,java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
        List<MovieDetails> list=MovieDao.getAllRecords();
        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="u">
        <div class="m1">
        <div class="m2">
            <img src="<c:out value="${u.image}" />" alt="<c:out value="${u.movie_desc}" />">
        </div>
        <div class="mbody">
            <span class="title"><c:out value="${u.moviename}" /></span>
            <p style="padding-top: '-20px';">
            <span><c:out value="${u.year}" /></span>&nbsp;&nbsp;&nbsp;
            <span><c:out value="${u.time}" /></span>&nbsp;&nbsp;&nbsp;
            <span> <c:out value="${u.genre}" /></span>
            </p>
            <span class="rating">
                <i class="fas fa-star"></i> <span style="color: #e8e8e8;"> <c:out value="${u.rating}" /></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="fas fa-thumbs-up" style="color:yellowgreen"></i><span style="color: #e8e8e8;"> <c:out value="${u.likes}" /></span>
                <br><br><br> <p class="des" style="color:#e8e8e8;"><c:out value="${u.movie_desc}" /></p><br>
            <div class="button">
        <a href="https://youtu.be/00mFeykBgVM?si=vJScVfnTGwtbhcVc"><button class="trailer"><i class="fas fa-play"></i> Watch Trailer</button></a>&nbsp;&nbsp;&nbsp;
       <a href="booking.html"> <button><i class="fas fa-film"></i>   Book Tickets</button></div></a>
        </div>
    </div>

<div class="space">
    <p></p>
</div>
    </c:forEach>

</body>
</html>
