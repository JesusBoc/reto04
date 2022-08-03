package com.reto04.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reto04.model.dao.ComprasDeLiderDAO;
import com.reto04.model.dao.DeudasPorProyectoDAO;
import com.reto04.model.dao.ProyectoBancoDAO;
import com.reto04.model.vo.ProyectoBancoVO;
import com.reto04.util.JDBCUtilities;

public class ReportesController {
    private ComprasDeLiderDAO reporteCompras;
    private DeudasPorProyectoDAO reporteProyecto;
    private ProyectoBancoDAO reporteBanco;
    
    public ReportesController(){
        reporteCompras = new ComprasDeLiderDAO();
        reporteProyecto = new DeudasPorProyectoDAO();
        reporteBanco = new ProyectoBancoDAO();
    }

    public void getBancoReports(String banco, String format){
        reporteBanco = new ProyectoBancoDAO();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT p.ID_Proyecto AS ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato, l.Nombre ||' '||l.Primer_Apellido||' '||l.Segundo_Apellido AS LIDER FROM Proyecto p JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo JOIN Lider l ON p.ID_Lider = l.ID_Lider WHERE Banco_Vinculado = ? ORDER BY Fecha_Inicio DESC, Ciudad, Constructora";
            conn = JDBCUtilities.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, banco);
            rs = stmt.executeQuery();
            String constructora, ciudad, clasificacion, lider;
            Integer id, estrato;
            while(rs.next()){
                constructora = rs.getString("Constructora");
                ciudad = rs.getString("Ciudad");
                clasificacion = rs.getString("Clasificacion");
                lider = rs.getString("LIDER");
                id = rs.getInt("ID");
                estrato = rs.getInt("estrato");
                reporteBanco.addProyecto(id, constructora, ciudad, clasificacion, estrato, lider);
            }
            showBancoReports(format);
            conn.close();
            rs.close();
        } catch (SQLException e) {
            printSQLErrors(e);
        }
    }

    public void showBancoReports(String format){
        for (ProyectoBancoVO proyecto : reporteBanco.getProyectos()) {
            System.out.println(String.format(format, proyecto.getId(), proyecto.getConstructora(), proyecto.getCiudad(),proyecto.getClasificacion(),
            proyecto.getEstrato(),proyecto.getNombre_lider()));
        }
    }

    public void getProyectoReports(Double limite){
        reporteProyecto = new DeudasPorProyectoDAO();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql= "SELECT p.ID_Proyecto, SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR FROM Proyecto p JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion WHERE c.Pagado = 'No' GROUP BY p.ID_Proyecto HAVING VALOR>? ORDER BY VALOR DESC";
        try {
            conn = JDBCUtilities.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, limite);
            rs = stmt.executeQuery();
            Integer id;
            Double valor;
            while(rs.next()){
                id = rs.getInt("ID_Proyecto");
                valor = rs.getDouble("VALOR");
                reporteProyecto.addDeuda(id, valor);
            }

        } catch (SQLException e) {
            printSQLErrors(e);
        }
    }
    public void getComprasReports(){
        reporteCompras = new ComprasDeLiderDAO();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT l.Nombre ||' '||l.Primer_Apellido||' '||l.Segundo_Apellido AS LIDER, SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR FROM Proyecto p JOIN Lider l ON p.ID_Lider = l.ID_Lider JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion GROUP BY LIDER ORDER BY VALOR DESC LIMIT 10";
        try {
            conn = JDBCUtilities.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            String nombre;
            Double valor;
            while(rs.next()){
                nombre = rs.getString("LIDER");
                valor = rs.getDouble("VALOR");
                reporteCompras.addCompra(nombre,valor);
            }
        } catch (SQLException e) {
            printSQLErrors(e);
        }
    }

    private void printSQLErrors(SQLException e) {
        System.out.println("Estado: "+e.getSQLState());
        System.out.println("Mensaje: "+e.getMessage());
        System.out.println("Estado: "+e.getLocalizedMessage());
    }
}
