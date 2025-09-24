package com.tecsup.semana_05.model.daos.Impl;

import com.tecsup.semana_05.model.daos.AdministradorDao;
import com.tecsup.semana_05.model.entities.Administrador;
import com.tecsup.semana_05.util.DBConn;

import java.sql.*;

public class AdministradorDaoCallableStatement implements AdministradorDao {

    private Connection con;
    private CallableStatement cst;
    private ResultSet rs;

    @Override
    public Administrador validar(String user, String password) {
        Administrador administrador = null;

        try(Connection con= DBConn.getConnection()){

            cst = con.prepareCall("{call sp_login(?,?)}");
            cst.setString(1, user);
            cst.setString(2, password);
            rs = cst.executeQuery();

            if(rs.next()){
                administrador = new Administrador();
                administrador.setCodigo(rs.getString(1));
                administrador.setLogin(rs.getString(2));
                administrador.setPassword(rs.getString(3));
                administrador.setNombres(rs.getString(4));
                administrador.setApellidos(rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return administrador;
    }
}
