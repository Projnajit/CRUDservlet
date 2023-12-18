package org.example.crudsystem;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.setAttribute("name",req.getParameter("name"));
        req.setAttribute("email",req.getParameter("email"));
        req.setAttribute("projectType",req.getParameter("projectType"));


        req.getRequestDispatcher("/pages/success.jsp").forward(req,resp);

    }
}
