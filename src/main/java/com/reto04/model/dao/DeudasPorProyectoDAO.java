package com.reto04.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.reto04.model.vo.DeudasPorProyectoVO;

public class DeudasPorProyectoDAO{
    private ArrayList<DeudasPorProyectoVO> deudas;
    public DeudasPorProyectoDAO(){
        deudas = new ArrayList<>();
    }
    public List<DeudasPorProyectoVO> getDeudas(){
        return deudas;
    }
    public void addDeuda(DeudasPorProyectoVO deuda){
        deudas.add(deuda);
    }
    public void addDeuda(Integer id, Double valor){
        DeudasPorProyectoVO deuda = new DeudasPorProyectoVO(id,valor);
        deudas.add(deuda);
    }
}