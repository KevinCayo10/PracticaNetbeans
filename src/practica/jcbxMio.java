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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author byron
 */
public class jcbxMio extends JComboBox<Object> {
    
    public jcbxMio() {
        cargarComboBox();
    }
    
    public void cargarComboBox() {
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            ArrayList<String> lista = new ArrayList<>();
            Conexion2 cc = new Conexion2();
            Connection cn = cc.conexion();
            
            String sql = "select * from estadocivil";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("est_sol"));
                lista.add(rs.getString("est_cas"));
                lista.add(rs.getString("est_viu"));
                lista.add(rs.getString("est_div"));
            }
            
            for (String dato : lista) {
                modelo.addElement(dato);
            }
            
            this.setModel(modelo);
        } catch (Exception ex) {
            Logger.getLogger(jcbxMio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
