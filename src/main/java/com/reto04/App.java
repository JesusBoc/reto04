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
        ReportesView view = new ReportesView();
        view.proyectosFinanciadosPorBanco("Conavi");
    }
}
