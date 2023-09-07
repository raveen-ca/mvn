<HTML>
<%@ page import="java.sql.*" %>
<%  Class.forName("org.mariadb.jdbc.Driver"); %>
<HEAD>
<TITLE> The view of Database table </TITLE>
</HEAD>
<BODY>
<%
  Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/mysql","root","root");
  Statement statement = connection.createStatement() ;
  ResultSet resultset = statement.executeQuery("select * from test.user_credentials");
%>
<TABLE BORDER="1">
<TR>
<TH>Id</TH>
<TH>Name</TH>
<TH>Password</TH>
</TR>
 <% while(resultset.next()){ %>
<TR>
<td> <%= resultset.getString(1) %></td>
<td> <%= resultset.getString(2) %></td>
<td> <%= resultset.getString(3) %></td>
</TR>
<% } %>
</TABLE>
</BODY>
</HTML>
