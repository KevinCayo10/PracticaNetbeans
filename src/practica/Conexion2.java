/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byron
 */
public class Conexion2 {

    Connection conect;

    public Connection conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/Practica", "root", "");
            System.out.println("Connecion satisfactoria");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conect;
    }

}
