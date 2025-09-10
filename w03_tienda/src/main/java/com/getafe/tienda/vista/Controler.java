package com.getafe.tienda.vista;

import java.io.IOException;
import java.util.Set;

import com.getafe.tienda.modelo.Fabricante;
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
				Set<Fabricante> fabs = neg.getFabricantes();
				req.setAttribute("fabs", fabs);
				req.getRequestDispatcher("/WEB-INF/vista/alta_producto.jsp").forward(req, resp);
				//
				break;
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
				double precio;
				Fabricante fab;
				if(!isEmpty(descripcion)
						&& !isEmpty(precioStr)
						&& !isEmpty(idFabStr)
						&& isDouble(precioStr)
						&& isInteger(idFabStr)
						&& (precio = Double.parseDouble(precioStr)) > 0
						&& (fab = neg.getFabricante(Integer.parseInt(idFabStr))) != null) {
						// si entro en este if, es porque todos los datos estan bien y damos de alta el producto
						req.setAttribute("producto", descripcion);
						try {
							neg.crearProducto(new Producto(descripcion, precio, fab));
							req.getRequestDispatcher("/WEB-INF/vista/alta_producto_ok.jsp").forward(req, resp);
						}catch (Exception e){
							req.getRequestDispatcher("/WEB-INF/vista/alta_producto_error.jsp").forward(req, resp);
						}
				}else {
					// cerramos la sesion porque la informacion enviada esta mal.
				}
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
		
		public boolean isEmpty(String param) {
			return param != null && param.trim().length() > 0;
		}
		
		public boolean isDouble(String num) {
			try {
				Double.parseDouble(num);
				return true;
			}catch (NumberFormatException e) {
				return false;
			}
		}
		
		public boolean isInteger(String num) {
			try {
				Integer.parseInt(num);
				return true;
			}catch (NumberFormatException e) {
				return false;
			}
		}

}

