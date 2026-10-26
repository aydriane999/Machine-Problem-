package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Validates the user's login credentials against initialization parameters
 * declared in web.xml.
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        // Normalize null to empty string and trim leading/trailing whitespace for empty checks
        boolean isUsernameEmpty = (inputUsername == null || inputUsername.trim().isEmpty());
        boolean isPasswordEmpty = (inputPassword == null || inputPassword.trim().isEmpty());

        ServletConfig config = getServletConfig();
        String configuredUsername = config.getInitParameter("username");
        String configuredPassword = config.getInitParameter("password");

        if (isUsernameEmpty && isPasswordEmpty) {
            request.setAttribute("errorMessage", "Both username and password fields are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (isUsernameEmpty) {
            request.setAttribute("errorMessage", "Username field is empty. Please enter a username.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (isPasswordEmpty) {
            request.setAttribute("errorMessage", "Password field is empty. Please enter a password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        boolean usernameMatches = inputUsername.equals(configuredUsername);
        boolean passwordMatches = inputPassword.equals(configuredPassword);

        if (usernameMatches && passwordMatches) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
        } else if (!usernameMatches && !passwordMatches) {
            request.setAttribute("errorMessage", "Incorrect username and password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        } else if (!usernameMatches) {
            request.setAttribute("errorMessage", "Incorrect username. The username entered does not match.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Incorrect password. The password entered does not match.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "LoginServlet - Validates login credentials using web.xml init-params";
    }
}
