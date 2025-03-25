<%@page import="com.urverse.dao.TicketDao"%>
<jsp:useBean id="u" class="com.urverse.booking.BookingDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i = TicketDao.sample(u);
String arrayAsString = TicketDao.getmydetails(u);
request.setAttribute("evearray", arrayAsString);
if (i > 0) {
    response.sendRedirect("viewusers.jsp");
    
} else {
    response.sendRedirect("index3.html");
}
%>
