package com.reto04.model.vo;

public class DeudasPorProyectoVO{
    private Integer id;
    private Double valor;
    
    public DeudasPorProyectoVO(Integer id, Double valor) {
        this.id = id;
        this.valor = valor;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}