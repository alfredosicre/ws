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
</head> 

<body>
	<header class="cabecera">
		<h2>Alta de Productos</h2>
	</header>
	
	<div id="contPrincipal">
		<p>El porducto <span id="prod"> ${producto } </span>se ha guardado correctamente</p>
		<a href="${home}/alta_producto"><button>Alta mas Productos</button></a>
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>	
	
</body>

</html>