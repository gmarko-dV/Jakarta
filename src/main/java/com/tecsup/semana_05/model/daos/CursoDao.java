package com.tecsup.semana_05.model.daos;

import com.tecsup.semana_05.model.entities.Curso;

import java.util.List;

public interface CursoDao extends EntidadDao<Curso,String> {
    public List<Curso> findByNombre(String nombre);
    public List<Curso> findByRangeCreditos(int min, int max);

}
