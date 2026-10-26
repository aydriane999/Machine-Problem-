package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Processes the input string from success.jsp and counts its characters
 * using character sets configured as init-params in web.xml.
 */
public class CharacterCountingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String inputString = request.getParameter("inputString");
        if (inputString == null) {
            inputString = "";
        }

        ServletConfig config = getServletConfig();
        String digitsSet = config.getInitParameter("digits");
        String vowelsSet = config.getInitParameter("vowels");
        String consonantsSet = config.getInitParameter("consonants");

        if (digitsSet == null) {
            digitsSet = "";
        }
        if (vowelsSet == null) {
            vowelsSet = "";
        }
        if (consonantsSet == null) {
            consonantsSet = "";
        }

        int length = inputString.length();
        int digits = 0;
        int vowels = 0;
        int consonants = 0;
        int symbols = 0;

        for (int i = 0; i < length; i++) {
            char ch = inputString.charAt(i);
            if (digitsSet.indexOf(ch) != -1) {
                digits++;
            } else if (vowelsSet.indexOf(ch) != -1) {
                vowels++;
            } else if (consonantsSet.indexOf(ch) != -1) {
                consonants++;
            } else if (!Character.isWhitespace(ch)) {
                symbols++;
            }
        }

        request.setAttribute("length", length);
        request.setAttribute("digits", digits);
        request.setAttribute("vowels", vowels);
        request.setAttribute("consonants", consonants);
        request.setAttribute("symbols", symbols);

        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "CharacterCountingServlet - Counts string length, digits, vowels, consonants, and symbols";
    }
}
