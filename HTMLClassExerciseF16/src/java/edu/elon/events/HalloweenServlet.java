/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.events;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eelkin
 */
public class HalloweenServlet extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //if servlet is entered from email.html page, servlet extracts values of four text input fields and prints name/value pairs to system.out
        String url = "/email.html";
        
        String action = request.getParameter("action");
        if(action == null) {
            action = "join";
        }
        
        if (action.equals("join")) {
            url = "/index.html";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } 
        else if (action.equals("subscribe")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String zipCode = request.getParameter("zipCode");

            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(email);
            System.out.println(zipCode);
            
            url = "/subscribe.html";
        }
        else {
            url = "/subscribe.html";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    } 

}
