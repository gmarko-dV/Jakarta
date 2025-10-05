<%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 17/09/2025
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tecsup.semana_05.model.entities.Curso" %>
<html>
<head>
  <title>Editar Curso</title>
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body class="principal-bg">
  <div class="container">
    <h2 class="titulo">Editar Curso</h2>
    <%
      Curso curso = (Curso) request.getAttribute("curso");
    %>
    <form action="CursoServlet?action=editar" method="post">
      <input type="hidden" name="id" value="<%= curso != null ? curso.getCodigo() : "" %>">
      <div>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= curso != null ? curso.getNombre() : "" %>" required>
      </div>
      <div>
        <label for="creditos">Créditos:</label>
        <input type="number" id="creditos" name="creditos" min="1" value="<%= curso != null ? curso.getCreditos() : "" %>" required>
      </div>
      <div style="margin-top:20px;">
        <button type="submit" class="menu-link">Actualizar</button>
        <a href="CursoServlet?action=listar" class="menu-link">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>
