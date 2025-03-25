<%@page import="com.urverse.nubean.NewUserDao"%>
<jsp:useBean id="u" class="com.urverse.newuser.NewUserDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i=NewUserDao.save(u);
if(i>0){
response.sendRedirect("movies.jsp");
}else{
response.sendRedirect("signuperror.html");
}
%>
