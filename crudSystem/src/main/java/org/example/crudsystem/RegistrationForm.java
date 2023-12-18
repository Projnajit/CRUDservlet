package org.example.crudsystem;

import java.sql.SQLException;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationForm extends HttpServlet {

    Connection con;
    public RegistrationForm() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projnajit","root","root");
            System.out.println(con);
        }
        catch(Exception e)
        {

        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String designation = req.getParameter("designation");
        String gender = req.getParameter("gender");
        String projectType = req.getParameter("projectType");
        String agreement = req.getParameter("agreement");


        if (agreement != null) {
            try {
                String sqlQuery="insert into users values(?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sqlQuery);
                ps.setString(1,name);
                ps.setString(2,id);
                ps.setString(3,password);
                ps.setString(4,email);
                ps.setString(5,designation);
                ps.setString(6,gender);
                ps.setString(7,projectType);

                ps.executeUpdate();

                req.getRequestDispatcher("SuccessServlet").forward(req, resp);
            }
            catch (SQLException e)
            {

            }
        } else {
            req.getRequestDispatcher("DeniedServlet").forward(req, resp);
        }
    }
}
