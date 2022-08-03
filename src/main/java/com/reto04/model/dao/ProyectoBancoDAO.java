package com.reto04.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.reto04.model.vo.ProyectoBancoVO;

public class ProyectoBancoDAO {
    private ArrayList<ProyectoBancoVO> proyectos;
    public ProyectoBancoDAO(){
        proyectos = new ArrayList<>();
    }
    public List<ProyectoBancoVO> getProyectos(){
        return proyectos;
    }
    public void addProyecto(ProyectoBancoVO proyecto){
        proyectos.add(proyecto);
    }
    public void addProyecto(Integer id, String constructora, String ciudad, String clasificacion, Integer estrato, String nombre_lider){
        ProyectoBancoVO proyecto = new ProyectoBancoVO(id, constructora, ciudad, clasificacion, estrato, nombre_lider);
        proyectos.add(proyecto);
    }
}
