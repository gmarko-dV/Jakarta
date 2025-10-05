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
  <title>Eliminar Curso</title>
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body class="principal-bg">
  <div class="container">
    <h2 class="titulo">Eliminar Curso</h2>
    <%
      Curso curso = (Curso) request.getAttribute("curso");
    %>
    <form action="CursoServlet?action=eliminar" method="post">
      <input type="hidden" name="id" value="<%= curso != null ? curso.getCodigo() : "" %>">
      <p>¿Está seguro que desea eliminar el curso <strong><%= curso != null ? curso.getNombre() : "" %></strong>?</p>
      <div style="margin-top:20px;">
        <button type="submit" class="menu-link">Eliminar</button>
        <a href="CursoServlet?action=listar" class="menu-link">Cancelar</a>
      </div>
    </form>
  </div>
</body>
</html>
