/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author thiag
 */
public class ConectaBanco {
    
    private static final String URL = "jdbc:mysql://myadmin.sabortrivial.com.br:3306/strivial_cardapio";
    
    // Banco Testes
   // private static final String URL = "jdbc:mysql://ec2-18-231-62-90.sa-east-1.compute.amazonaws.com:3306/strivial_cardapio";
    
    private static final String DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String USER = "strivial_st";
    private static final String SENHA = "132St413";
    
    private static Connection  con = null;

    public static Connection cb() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL,USER,SENHA);
        return con;        
    }
    
    public static void db() {
        try {
            con.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
    
    
}