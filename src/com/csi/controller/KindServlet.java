package com.csi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KindServlet",urlPatterns = "/manager/demo.do")
public class KindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("context");
        request.setAttribute("pp",content);
        System.out.println(content);
        request.getRequestDispatcher("demo.jsp").forward(request,response);
    }

}
