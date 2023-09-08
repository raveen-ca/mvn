
package com.cslc.MainPackage;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;


public class valid extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException {
        PrintWriter out = response.getWriter();
        String connectionURL ="jdbc:mariadb://127.0.0.1:3310/mysql";
        Connection connection = null;
        ResultSet rs=null;
        String user_name = request.getParameter("user_name");
        String user_password =request.getParameter("user_password");
        response.setContentType("text/html");

        try{
             Class.forName("org.mariadb.jdbc.Driver"); connection = DriverManager.getConnection(connectionURL, "root", "root");
            String sql = "SELECT * FROM test.user_credentials WHERE user_name = ? AND user_password = ?";
           

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_password);
 Statement s = connection.createStatement();
             rs =preparedStatement.executeQuery();
////if there are next ib rs so you have a user by this id and password
             if(rs.next()) {
               out.println("The user is found");
             }
             else {
               out.println("The user is not found");
             }

        }catch(Exception e) {
               out.println("The exception is" + e);
        }
    }
}

