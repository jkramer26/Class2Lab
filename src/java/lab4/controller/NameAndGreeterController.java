/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.WelcomeService;

/**
 *
 * @author owner
 */
@WebServlet(name = "NameAndGreeter", urlPatterns = {"/greeter"})
public class NameAndGreeterController extends HttpServlet {

    private static final String RESULT_PAGE = "lab4/welcomeResult.jsp";


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.setContentType("text/html");
        //retriving the first and last name from welcome.html
        String fn = request.getParameter("welcomeFirstName");
        String ln = request.getParameter("welcomeLastName");

        // Create a new instance of a model object
        WelcomeService ws = new WelcomeService();
        // Trim and/or validate input data
        //setting the full name and retrieving the welcome message
        String result2 = ws.getWelcomeMessage(fn, ln);

        request.setAttribute("welcomeMessage", result2);

        // This object lets you forward both the request and response
        // objects to a destination page (aka result_page)
        //get data to the view
        //this is done so it doesn't die at controller
        RequestDispatcher view
                = request.getRequestDispatcher(RESULT_PAGE);
        //forwarding the request and response
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
