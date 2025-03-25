<%@page import="com.urverse.mdao.MovieDao"%>
<jsp:useBean id="u" class="com.urverse.movies.MovieDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i=MovieDao.save(u);
if(i>0){
response.sendRedirect("movies.jsp");
}else{
response.sendRedirect("index2.html");
}
%>
