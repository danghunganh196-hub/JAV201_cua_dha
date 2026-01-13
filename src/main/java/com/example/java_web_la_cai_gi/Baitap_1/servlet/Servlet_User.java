package com.example.java_web_la_cai_gi.Baitap_1.servlet;

import com.example.java_web_la_cai_gi.Baitap_1.Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet_User", value = {"/Servlet_User","/login"
})
public class Servlet_User extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenUser = request.getParameter("tenUser");
        String passWord = request.getParameter("passWord");
        User u = new User(tenUser,passWord);

        request.setAttribute("us", u);
        request.getRequestDispatcher("/view/AfterLogForm.jsp").forward(request,response);
    }
}
