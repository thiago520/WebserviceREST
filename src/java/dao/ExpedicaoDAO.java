/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Expedicao;

/**
 *
 * @author thiag
 */
public class ExpedicaoDAO {
    
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;    
    
    public List<Expedicao> getListaExpedicao() throws ClassNotFoundException, SQLException {
        
        List<Expedicao> expedicao = new ArrayList<>();
        Expedicao exp = null;
        
        sql = "select pedido.cod_pedido,clientes.nome_cliente,pedido.status from clientes,pedido where pedido.cod_cliente = clientes.id_cliente and pedido.data_agendada = CURRENT_DATE and pedido.status = 'Em Preparo'";
        con = ConectaBanco.cb();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()) {
            exp = new Expedicao();
            exp.setCod_pedido(rs.getInt("cod_pedido"));  
            exp.setNome_cliente(rs.getString("nome_cliente"));
            exp.setStatus(rs.getString("status"));

            expedicao.add(exp);
        }
        ConectaBanco.db();
        return expedicao;
    }
    
 /*   public boolean inserirExpedicao(Expedicao exp) {                
        try {            
            sql = "INSERT INTO (cod_pedido,nome_cliente,status) values (?,?,?)";          
            con = ConectaBanco.cb(); 
            pst = con.prepareStatement(sql);
            pst.setInt(1, exp.getCod_pedido());
            pst.setString(2, exp.getNome_cliente());
            pst.setString(3, exp.getStatus());
            pst.execute();
            ConectaBanco.db();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExpedicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    } */
    
  /*  public boolean deletarExpedicao(int id) {
        
        // COLOCAR EXCLUSAO DE ITENS DO PEDIDO e VOLTA DO DE QUANTIDADE DE ESTOQUE
        try {
                sql = "DELETE FROM pedido where cod_pedido = ?";
                con = ConectaBanco.cb(); 
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);                
                pst.execute();
                ConectaBanco.db();
                return true;
        } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ExpedicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }               
    } */
    
    public boolean atualizarExpedicao(Expedicao exp) {                
        try {              
            sql = "UPDATE pedido SET status = ?, datahora_saida = SYSDATE(), entregador = ? WHERE cod_pedido = ?";          
            con = ConectaBanco.cb(); 
            pst = con.prepareStatement(sql);
            pst.setString(1, exp.getStatus());                      
            pst.setString(2, exp.getEntregador());
            pst.setInt(3, exp.getCod_pedido());            
            pst.executeUpdate();
            ConectaBanco.db();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExpedicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    } 
    
}
