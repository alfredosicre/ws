package com.getafe.tienda.vista;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tienda/*")
public class Controler extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("req.getCharacterEncoding(): " + req.getCharacterEncoding());
			System.out.println("req.getContentPath(): " + req.getContextPath()); 
			System.out.println("req.getPathInfo(): " + req.getPathInfo()); // http://localhost:8080/w03_tienda/tienda/algo de esta peticion nos da /algo, el asterisco de arriba
			
			String path = req.getPathInfo();
			// depende de lo que me pida, cojo la opcion correspondiente
			
			switch(path) {
			case "/informacion":
				req.setAttribute("origen", "el que te envió esto fuí yo, el controlador!!");
				req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);
				break;
			case "/menu_principal":
				req.getRequestDispatcher("/WEB-INF/vista/menu_principal.jsp").forward(req, resp);
				break;
			
			}
			
		}
		
		@Override
		public void init() throws ServletException {
			
			ServletContext app = getServletContext();
			app.setAttribute("home", app.getContextPath() + "/tienda" );
			app.setAttribute("css", app.getContextPath() + "/css");
			
		}

}

