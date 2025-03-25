<%@page import="com.urverse.ubean.UserDao"%>
<jsp:useBean id="u" class="com.urverse.user.UserDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserDao.validateUser(u);
if(i>0){
response.sendRedirect("movies.jsp");
}else{
response.sendRedirect("loginerror.html");
}
%>
