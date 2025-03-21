<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Processing Page</title>
    </head>
    <body>
        <%
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/2815", "root", "root");
                String uname = request.getParameter("uname");
                String pwd = request.getParameter("pwd");
                PreparedStatement pst = con.prepareStatement("SELECT password FROM users WHERE username = ?");
                pst.setString(1, uname);
                ResultSet rs = pst.executeQuery();
                if(rs.next()) {
                    if(rs.getString(1).equals(pwd)) {
                        %>
                        <%@include file = "WelcomePage.html"%>
                        <% }  else{
                                %>
                                <h2>LOGIN FAILED</h2>
                                <%@include file = "login_process.jsp"%>
                                <%
                    }
                } else {
                    %>
                    <%="User doesn't exists"%>
                    <%@include file="home.jsp"%>
                    <%
                }
            } catch (Exception e) {
                out.println(e.toString());
            }
        %>
    </body>
</html>
