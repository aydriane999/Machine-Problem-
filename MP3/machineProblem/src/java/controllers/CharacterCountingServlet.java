package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterCountingServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String inputString=request.getParameter("inputString");
        if (inputString==null){
            inputString="";
        }

        String digitsSet=getServletConfig().getInitParameter("digits");
        String vowelsSet=getServletConfig().getInitParameter("vowels");
        String consonantsSet=getServletConfig().getInitParameter("consonants");

        if (digitsSet==null)digitsSet="0123456789";
        if (vowelsSet==null)vowelsSet="aeiouAEIOU";
        if (consonantsSet==null)consonantsSet="bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

        int stringLength=inputString.length();
        int digitCount=0;
        int vowelCount=0;
        int consonantCount=0;
        int symbolCount=0;

        for(int i=0;i<inputString.length();i++){
            char ch=inputString.charAt(i);

            if(Character.isWhitespace(ch)){
                continue;
            }
            if(digitsSet.indexOf(ch)!=-1){
                digitCount++;
            } else if(vowelsSet.indexOf(ch)!=-1){
                vowelCount++;
            } else if(consonantsSet.indexOf(ch)!=-1){
                consonantCount++;
            } else{
                symbolCount++;
            }
        }

        request.setAttribute("inputString",inputString);
        request.setAttribute("stringLength",stringLength);
        request.setAttribute("digitCount",digitCount);
        request.setAttribute("vowelCount",vowelCount);
        request.setAttribute("consonantCount",consonantCount);
        request.setAttribute("symbolCount",symbolCount);

        RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.sendRedirect("success.jsp");
    }
}