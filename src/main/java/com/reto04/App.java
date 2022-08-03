package com.reto04;
import com.reto04.view.ReportesView;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Pruebas de funcionalidad
        ReportesView view = new ReportesView();
        view.proyectosFinanciadosPorBanco("Conavi");
        double limiteInferior = 50_000d;
        view.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
        view.lideresQueMasGastan();
    }
}
