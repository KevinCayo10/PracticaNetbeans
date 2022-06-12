/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Estudiante
 */
public class Conexion1 {

    /**
     * @param args the command line arguments
     */
    Connection conect;

    public Connection conexion() {
        try {
          Class.forName("com.mysql.jdbc.Driver");
          conect = DriverManager.getConnection("jdbc:mysql://localhost/Practica","root","");
            System.out.println("Si hubo conexion");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conect;
    }

}
