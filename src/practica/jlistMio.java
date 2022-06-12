/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class jlistMio extends JList<Object> {

    public jlistMio() {
        mostrarDatos();
    }

    public void mostrarDatos() {
        try {
            DefaultListModel modelo = new DefaultListModel();
            // est_nombre, est_apellido, est_cedula
            String[] datos = new String[3];
            Conexion1 cc = new Conexion1();
            Connection cn = cc.conexion();

            String sql = "select * from estudiantes";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);

            System.out.println("Despues del rs");

            while (rs.next()) {
                datos[0] = rs.getString("est_cedula");
                datos[1] = rs.getString("est_nombre");
                datos[2] = rs.getString("est_apellido");
                modelo.addElement(datos[0].toString());
                modelo.addElement(datos[1].toString());
                modelo.addElement(datos[2].toString());
            }

            this.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
