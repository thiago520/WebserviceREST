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
    
    private static Connection  con = null;

    public static Connection cb() throws ClassNotFoundException, SQLException {
        Class.forName(Dados.DRIVER);
        con = DriverManager.getConnection(Dados.URL,Dados.USER,Dados.SENHA);
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