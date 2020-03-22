package com.entech.webapp.WebAppProj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@WebServlet("/LoginController")
public class LoginController{

	public LoginController() {
        super();
    }
	
	@RequestMapping(value="/LoginController", method=RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@RequestMapping(value="/LoginController", method=RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		if(uname.equals("entech.surveycustodian@gmail.com")&& pass.equals("pwd")) { 
			//above will change path when we integrate
			response.sendRedirect("/views/member.html");
		} else { 
			//soon I will figure out how to do the max 4 failed login attempts.
			response.sendRedirect("login");

			
		}
	}
    
}