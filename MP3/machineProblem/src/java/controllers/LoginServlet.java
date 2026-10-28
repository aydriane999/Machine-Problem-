package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        String inputUsername=request.getParameter("username");
        String inputPassword=request.getParameter("password");

        String configUsername=getServletConfig().getInitParameter("username");
        String configPassword=getServletConfig().getInitParameter("password");

        boolean isUserEmpty=(inputUsername == null || inputUsername.trim().isEmpty());
        boolean isPassEmpty=(inputPassword == null || inputPassword.trim().isEmpty());

        if (isUserEmpty && isPassEmpty){
            request.setAttribute("errorMessage","Both Username and Password fields are required.");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
            return;
        }

        if (isUserEmpty){
            request.setAttribute("errorMessage","Username cannot be empty. Please enter your username.");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
            return;
        }

        if (isPassEmpty){
            request.setAttribute("errorMessage","Password cannot be empty. Please enter your password.");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
            return;
        }

        if (!inputUsername.equals(configUsername)){
            request.setAttribute("errorMessage","The username entered is incorrect.");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
            return;
        }

        if (!inputPassword.equals(configPassword)){
            request.setAttribute("errorMessage","The password entered is incorrect.");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
            return;
        }

        request.setAttribute("username",inputUsername);
        RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.sendRedirect("index.jsp");
    }
}