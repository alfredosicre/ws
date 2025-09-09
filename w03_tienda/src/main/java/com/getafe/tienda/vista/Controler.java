package com.getafe.tienda.vista;

import java.io.IOException;
import java.util.Set;

import com.getafe.tienda.modelo.Producto;
import com.getafe.tienda.negocio.Tienda;
import com.getafe.tienda.negocio.TiendaImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tienda/*")
public class Controler extends HttpServlet {
	
	private Tienda neg;

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
			case "/listado_productos":
				req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
				break;
			case "/alta_producto":
				req.getRequestDispatcher("/WEB-INF/vista/alta_producto.jsp").forward(req, resp);
			
			}
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String path = req.getPathInfo();
			switch(path) {
			case "/listado_productos":
				String descripcion = req.getParameter("descripcion");
				Set<Producto> prods;
				if(descripcion != null && descripcion.length() > 0) {
					prods = neg.getProductos(descripcion);
				}else {
					prods = neg.getProductos();
				}
				req.setAttribute("prods", prods);
				req.getRequestDispatcher("/WEB-INF/vista/listado_productos.jsp").forward(req, resp);
			break;
			case "/alta_producto":
				descripcion = req.getParameter("descripcion");
				String precioStr = req.getParameter("precio");
				String idFabStr = req.getParameter("idFabricante");
				System.out.println(descripcion);
				System.out.println(precioStr);
				System.out.println(idFabStr);
				break;
			}
		}
		
		@Override
		public void init() throws ServletException {
			
			neg = new TiendaImpl();
			
			ServletContext app = getServletContext();
			app.setAttribute("home", app.getContextPath() + "/tienda" );
			app.setAttribute("css", app.getContextPath() + "/css");
			
		}

}

