package com.reto04.model.vo;

public class ProyectoBancoVO {
    private Integer id;
    private String constructora;
    private String ciudad;
    private String clasificacion;
    private Integer estrato;
    private String nombre_lider;
    
    public ProyectoBancoVO(Integer id, String constructora, String ciudad, String clasificacion, Integer estrato,
            String nombre_lider) {
        this.id = id;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.clasificacion = clasificacion;
        this.estrato = estrato;
        this.nombre_lider = nombre_lider;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Integer getEstrato() {
        return estrato;
    }
    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }
    public String getNombre_lider() {
        return nombre_lider;
    }
    public void setNombre_lider(String nombre_lider) {
        this.nombre_lider = nombre_lider;
    }
    
}
