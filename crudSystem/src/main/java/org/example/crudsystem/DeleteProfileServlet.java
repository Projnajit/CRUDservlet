package org.example.crudsystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProfileServlet extends HttpServlet {
    Connection con;
    public DeleteProfileServlet() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projnajit","root","root");
            System.out.println(con);
        }
        catch(Exception e)
        {

        }
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        String query="Delete From users WHERE id=?";

        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,req.getParameter("id"));
            int rest=ps.executeUpdate();

            if(rest>0){
                out.println("<h1>Profile is deleted!!<h1/>");
            }
            else{
                out.println("<h1>Profile is not deleted!!<h1/>");
            }
        }
        catch (SQLException e){
            out.println("<h1>Database issue occurs.<h1/>");
        }

    }
}
