<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
<link rel="stylesheet" type="text/css" href="${css}/productos.css">

<script type="text/javascript">

function solicitud(){
	// preparamos los parametros para la peticion:
	let param = "idFabricante=" + encodeURIComponent(document.getElementById("idFabricante").value);
	// creamos el objeto que nos permitirá hacer la peticion
	let req = new XMLHttpRequest();
	// indicamos el metodo HTTP y la URI(o URL)
	req.open("post", "productos_fabricante_json_respuesta");
	// registrar la funcion o el oyente al evento readystatechange, cambio de estado cuando reciba respuesta
	req.addEventListener("readystatechange", 
			function(){
				if(req.readyState == 4 && req.status == 200){ // 4 es que me han contestado y 200 codigo de respuesta HTTP
					cargarTabla(req);
				}
	});
	// armar la cabecera
	req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	//realizar la peticion
	req.send(param);
	
}

function cargarTabla(req){
	console.log(req.responseText);
	
}

	window.onload = function(){
		document.getElementById("idFabricante").addEventListener("change", solicitud);
	}

</script>

</head> 

<body>
	<header class="cabecera">
		<h2>Busqueda de Productos por Fabricante</h2>
	</header>
	
	<div id="contPrincipal">
		<form action="${home}/productos_fabricante" method= "post">
		
			<select id = "idFabricante" name = "idFabricante">
				<option hidden="hidden" value ="" >Selecciona un fabricante</option>
				
				<c:forEach var="fabricante" items="${fabs}">
					<option value="${fabricante.idFabricante}" > ${fabricante.fabricante}</option>
				</c:forEach>
			</select>
			
		</form>
		
		<c:if test="${not empty fab }"> 
		<table id = "tabla_datos">
			<thead>
				<tr>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Fabricante</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
					
		</table>
		</c:if>
		
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>	
</body>

</html>