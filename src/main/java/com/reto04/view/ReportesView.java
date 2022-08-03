package com.reto04.view;

import com.reto04.controller.ReportesController;

public class ReportesView {
    private ReportesController controller;

    public ReportesView(){
        controller = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces){
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }
    
    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            controller.getBancoReports(banco,"%3d %-25s %-20s %-15s %7d %-30s");
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            controller.getProyectoReports(limiteInferior, "%3d %,15.1f");
        }
    }

    public void lideresQueMasGastan(){
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                        + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        controller.getComprasReports("%-25s %,15.1f");
    }
}
