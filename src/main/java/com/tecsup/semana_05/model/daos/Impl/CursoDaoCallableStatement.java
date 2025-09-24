package com.tecsup.semana_05.model.daos.Impl;

import com.tecsup.semana_05.model.daos.CursoDao;
import com.tecsup.semana_05.model.entities.Curso;
import com.tecsup.semana_05.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

public class CursoDaoCallableStatement implements CursoDao {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cst;



    @Override
    public List<Curso> findByNombre(String nombre) {
        return List.of();
    }

    @Override
    public List<Curso> findByRangeCreditos(int min, int max) {
        return List.of();
    }

    @Override
    public void create(Curso curso) {
        try (Connection con = DBConn.getConnection();
             CallableStatement cst=con.prepareCall("{call sp_ins_curso(?,?,?)}")
        ) {
            cst.setString(1, curso.getCodigo());
            cst.setString(2, curso.getNombre());
            cst.setInt(3,curso.getCreditos());
            cst.executeUpdate();

        }
        catch (SQLException e){
            System.out.println("Error al insertar el curso");
        }

    }

    @Override
    public Curso find(String id) {
        Curso curso = null;

        try(Connection con = DBConn.getConnection();
            CallableStatement cst = con.prepareCall("{call sp_find_curso(?)}"))
        {
            cst.setString(1, id);
            rs = cst.executeQuery();
            if(rs.next()){
                curso = new Curso(rs.getString("chrCurCodigo"),rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos"));
            }
        }
        catch (SQLException e){
            System.out.println("Error en la Consulta del curso");
        }
        return null;
    }

    @Override
    public List<Curso> findAll() {
        return List.of();
    }

    @Override
    public void update(Curso curso) {

    }

    @Override
    public void delete(String id) {

    }
}
