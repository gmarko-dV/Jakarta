<%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 17/09/2025
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tecsup.semana_05.model.entities.Curso" %>
<html>
<head>
  <title>Listado de Cursos</title>
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<h2>Listado de Cursos</h2>
<a href="CursoServlet?action=agregar">Agregar Curso</a>
<table border="1">
  <tr>
    <th>Código</th>
    <th>Nombre</th>
    <th>Créditos</th>
    <th>Acciones</th>
  </tr>
  <%
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
    if (cursos != null) {
      for (Curso curso : cursos) {
  %>
  <tr>
    <td><%= curso.getCodigo() %></td>
    <td><%= curso.getNombre() %></td>
    <td><%= curso.getCreditos() %></td>
    <td>
      <a href="CursoServlet?action=editar&id=<%= curso.getCodigo() %>">Editar</a>
      <a href="CursoServlet?action=eliminar&id=<%= curso.getCodigo() %>" onclick="return confirm('¿Seguro que desea eliminar este curso?');">Eliminar</a>
    </td>
  </tr>
  <%      }
    }
  %>
</table>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
