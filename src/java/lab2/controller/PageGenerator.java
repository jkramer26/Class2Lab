package lab2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jkramer26
 */
//normal class that entrends a superclass. Means has certain methods that have to be overwritten
//annotaiton congifures servelt with name and url pattern
//the superclass that gets inherited by all servelts
@WebServlet(name = "PageGenerator", urlPatterns = {"/pager"})
public class PageGenerator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //optional method that netbeans created for conveyance 
    //convient because there are times when you want to handle the processing of a get and post differently. 
    //Can be called by either doGet or doPost
    //request object and respond object. <-- created automatically by the server. (and destroyed)
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //determine how the output should be 
        response.setContentType("text/html;charset=UTF-8");
        //no system so we use printwriter to output text. This will go in the html stream that the servelt sends back to the browser
        //pretending there is no file and generating an html page on the fly with print statements
        //creating a page in the memory and this will get sent back to the browser
        //getting a print object so we can write into the stream
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //basic needed tags
            //parameter is read only
            String color = request.getParameter("color");  //this won't error out if there is no parameter for it and will essentially ignore it
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PageGenerator</title>");            
            out.println("</head>");
            out.println("<body>");
            //this is our content
            out.println("<h1>Welcome " + firstName + " " + lastName + "</h1>");
            out.println("<h1 style='color:" + color + "'>Lab 2 Activity</h1>");

            out.println("<table border=1>");
                for (int j = 0; j < 3; j++) {
                    out.println("<tr>");
                        for (int g = 0; g < 3; g++ ) {
                            out.println("<td>");
                            out.println("</td>");
                            
                        }
                    out.println("</tr>");
                }

            out.println("</table>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
