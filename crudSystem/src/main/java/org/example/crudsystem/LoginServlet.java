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
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    Connection con;

    public LoginServlet() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projnajit","root","root");
            System.out.println("login: " + con);
        }
        catch(Exception e)
        {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        try
        {
            String query = "Select * from users where id=? and password=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,password);
            ResultSet rest = ps.executeQuery();

            if(rest.next())
            {
                req.setAttribute("retrivedId",rest.getString("id"));
                req.setAttribute("retrivedName",rest.getString("name"));
                req.setAttribute("retrivedEmail",rest.getString("email"));
                req.setAttribute("retrivedPassword",rest.getString("password"));
                req.setAttribute("retrivedDesignation",rest.getString("designation"));
                req.setAttribute("retrivedGender",rest.getString("gender"));
                req.setAttribute("retrivedProjectType",rest.getString("projectType"));
                req.setAttribute("retrivedImageName",rest.getString("imageName"));


                req.getRequestDispatcher("/pages/updateDelete.jsp").forward(req,resp);

            }
            else
            {
                out.println("Sorry! Wrong Credentials");
            }
        }
        catch (Exception e)
        {
            out.println("hello, not matching!!");
        }
    }
}
