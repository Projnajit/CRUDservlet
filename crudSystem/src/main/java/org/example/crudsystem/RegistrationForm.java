package org.example.crudsystem;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@MultipartConfig
public class RegistrationForm extends HttpServlet {

    Connection con;
    public RegistrationForm() {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projnajit","root","root");
            System.out.println(con);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
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

        Part file=req.getPart("image");

        String imageFile=file.getSubmittedFileName(); // this string i need to access from the success servlet where i am forwarding below

        req.setAttribute("imageFile",imageFile);

//        String uploadPath= "src/main/images" +imageFile;
        String uploadPath = req.getServletContext().getRealPath("/images/") + imageFile;

        System.out.println(uploadPath);

        try {
            FileOutputStream fos=new FileOutputStream(uploadPath);
            InputStream is=file.getInputStream();

            byte[] data =  new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (agreement != null) {
            try {
                String sqlQuery="insert into users values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sqlQuery);
                ps.setString(1,name);
                ps.setString(2,id);
                ps.setString(3,password);
                ps.setString(4,email);
                ps.setString(5,designation);
                ps.setString(6,gender);
                ps.setString(7,projectType);
                ps.setString(8,imageFile);

                ps.executeUpdate();

                req.getRequestDispatcher("SuccessServlet").forward(req, resp);
            }
            catch (SQLException e)
            {
                out.println("Choose different ID");
            }
        } else {
            req.getRequestDispatcher("DeniedServlet").forward(req, resp);
        }
    }
}
