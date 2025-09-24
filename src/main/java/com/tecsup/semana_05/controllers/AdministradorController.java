package com.tecsup.semana_05.controllers;

import com.tecsup.semana_05.model.entities.Administrador;
import com.tecsup.semana_05.services.AdministradorService;
import com.tecsup.semana_05.services.Impl.AdministradorServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdministradorController", urlPatterns = {"/sValidador", "/admin"})
public class AdministradorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Capturamos los parámetros enviados desde el formulario
        String sUsuario = request.getParameter("txtUsuario");
        String sPassword = request.getParameter("txtPassword");

        // Usamos el servicio para validar
        AdministradorService servicio = new AdministradorServiceImpl();
        Administrador adm = servicio.validar(sUsuario, sPassword);

        // Validamos credenciales
        if (adm != null) {
            // Guardamos el administrador en la sesión
            request.getSession().setAttribute("eladministrador", adm);
            // Redirigimos a la página principal
            response.sendRedirect("principal.jsp");
        } else {
            // Si no existe, mandamos al error.jsp
            response.sendRedirect("error.jsp");
        }
    }
}
