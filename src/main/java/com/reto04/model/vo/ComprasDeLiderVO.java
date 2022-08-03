package com.reto04.model.vo;

public class ComprasDeLiderVO {
    private String nombre;
    private Double valor;
    

    public ComprasDeLiderVO(String nombre, Double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
