package com.tecsup.semana_05.controllers;

import com.tecsup.semana_05.model.entities.Curso;
import com.tecsup.semana_05.model.daos.CursoDao;
import com.tecsup.semana_05.model.daos.Impl.CursoDaoCallableStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CursoServlet")
public class CursoServlet extends HttpServlet {
    private CursoDao cursoDao = new CursoDaoCallableStatement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "index";
        switch (action) {
            case "listar":
                List<Curso> cursos = cursoDao.findAll();
                request.setAttribute("cursos", cursos);
                request.getRequestDispatcher("cursoMan.jsp").forward(request, response);
                break;
            case "agregar":
                request.getRequestDispatcher("cursoInsertar.jsp").forward(request, response);
                break;
            case "editar":
                String id = request.getParameter("id");
                Curso curso = cursoDao.find(id);
                request.setAttribute("curso", curso);
                request.getRequestDispatcher("cursoActualizar.jsp").forward(request, response);
                break;
            case "eliminar":
                String idEliminar = request.getParameter("id");
                cursoDao.delete(idEliminar);
                response.sendRedirect("CursoServlet?action=listar");
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "index";
        switch (action) {
            case "agregar":
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                int creditos = Integer.parseInt(request.getParameter("creditos"));
                Curso nuevoCurso = new Curso(codigo, nombre, creditos);
                cursoDao.create(nuevoCurso);
                response.sendRedirect("CursoServlet?action=listar");
                break;
            case "editar":
                String id = request.getParameter("id");
                String nombreEdit = request.getParameter("nombre");
                int creditosEdit = Integer.parseInt(request.getParameter("creditos"));
                Curso cursoEdit = new Curso(id, nombreEdit, creditosEdit);
                cursoDao.update(cursoEdit);
                response.sendRedirect("CursoServlet?action=listar");
                break;
            case "eliminar":
                String idEliminar = request.getParameter("id");
                cursoDao.delete(idEliminar);
                response.sendRedirect("CursoServlet?action=listar");
                break;
            default:
                response.sendRedirect("CursoServlet?action=index");
                break;
        }
    }
}
