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

public class UpdateProfileServlet extends HttpServlet {

    Connection con;
    public UpdateProfileServlet() {
        try
        {
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

        try {
            //update data
            String query="UPDATE users SET name=?, id=?, password=?, email=?, designation=?, gender=?, projectType=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,req.getParameter("name"));
            ps.setString(2,req.getParameter("id"));
            ps.setString(3,req.getParameter("password"));
            ps.setString(4,req.getParameter("email"));
            ps.setString(5,req.getParameter("designation"));
            ps.setString(6,req.getParameter("gender"));
            ps.setString(7,req.getParameter("projectType"));
            ps.setString(8,req.getParameter("id"));
            int rest = ps.executeUpdate();
            System.out.println(rest);
            if(rest>0){
                out.println("<h1>Profile Updated Successfully!!</h1>");
            }
            else{
                out.println("<b>Don't leave any field empty, update field or keep them same.</b>");
            }

        }
        catch (SQLException e){
            out.println("Error: "+e);
        }
    }
}
