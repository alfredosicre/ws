package com.getafe.tienda.vista;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WEB-INF/informacion")
public class Info extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		System.out.println(req.getAttribute("origen"));
		
		out.println("METODOS DE LA PETICION");
		out.println("req.getCharacterEncoding(): " + req.getCharacterEncoding());
		out.println("req.getContentPath(): " + req.getContextPath()); 
		out.println("req.getPathInfo(): " + req.getPathInfo());
	}
	
}
