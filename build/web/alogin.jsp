<%@page import="com.urverse.abean.AdminDao"%>
<jsp:useBean id="u" class="com.urverse.admin.AdminDetails"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=AdminDao.validateUser(u);
if(i>0){
response.sendRedirect("adminmovies.jsp");
}else{
response.sendRedirect("adminerror.html");
}
%>
