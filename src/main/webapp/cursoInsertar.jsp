<%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 17/09/2025
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Agregar Curso</title>
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body class="principal-bg">
  <div class="container">
    <h2 class="titulo">Agregar Curso</h2>
    <form action="CursoServlet?action=agregar" method="post">
      <div>
        <label for="codigo">Código:</label>
        <input type="text" id="codigo" name="codigo" required>
      </div>
      <div>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
      </div>
      <div>
        <label for="creditos">Créditos:</label>
        <input type="number" id="creditos" name="creditos" min="1" required>
      </div>
      <div style="margin-top:20px;">
        <button type="submit" class="menu-link">Guardar</button>
        <a href="CursoServlet?action=listar" class="menu-link">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>
