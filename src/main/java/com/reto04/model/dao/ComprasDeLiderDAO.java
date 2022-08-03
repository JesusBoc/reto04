package com.reto04.model.dao;

import com.reto04.model.vo.ComprasDeLiderVO;

public class ComprasDeLiderDAO {
    private ComprasDeLiderVO[] compras;

    public ComprasDeLiderDAO(){
        compras = new ComprasDeLiderVO[10];
    }

    public ComprasDeLiderVO[] getCompras(){
        return compras;
    }
    
    public void addCompra(ComprasDeLiderVO compra){
        for (ComprasDeLiderVO comprasDeLiderVO : compras) {
            if(comprasDeLiderVO == null){
                comprasDeLiderVO = compra;
                break;
            }
        }
    }
    public void addCompra(String nombre, Double valor){
        for (int i = 0;i<10;i++) {
            if(compras[i] == null){
                ComprasDeLiderVO compra = new ComprasDeLiderVO(nombre, valor);
                compras[i] = compra;
                break;
            }
        }
    }
}
