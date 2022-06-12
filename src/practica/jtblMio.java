/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author byron
 */
public class jtblMio extends JTable {

    public jtblMio() {
        cargarTabla("");
    }

    public void cargarTabla(String dato) {

        try {
            DefaultTableModel modelo;
            String datos[] = new String[4];
            String titulos[] = {"Cedula", "Nombre", "Apellido", "EstadoCivil"};
            modelo = new DefaultTableModel(null, titulos);

            Conexion4 cc = new Conexion4();
            Connection cn = cc.conexion();

            String sql = "select * from estudiantes where est_cedula like '%" + dato + "%'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString("est_cedula");
                datos[1] = rs.getString("est_nombre");
                datos[2] = rs.getString("est_apellido");
                datos[3] = rs.getString("est_estadocivil");
                modelo.addRow(datos);
            }

            this.setModel(modelo);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
