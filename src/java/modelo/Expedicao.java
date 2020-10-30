/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author thiag
 */
public class Expedicao {

      
    private int cod_pedido;
    private String nome_cliente;
    private String status;    
    private String entregador;
    
    public Expedicao() {
        
    }
    
    public Expedicao(int cod_pedido, String nome_cliente, String status, String entregador) {
        this.cod_pedido = cod_pedido;
        this.nome_cliente = nome_cliente;
        this.status = status;        
        this.entregador = entregador;
    }
    
    
    /**
     * @return the cod_pedido
     */
    public int getCod_pedido() {
        return cod_pedido;
    }

    /**
     * @param cod_pedido the cod_pedido to set
     */
    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }         
  
    /**
     * @return the entregador
     */
    public String getEntregador() {
        return entregador;
    }

    /**
     * @param entregador the entregador to set
     */
    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }
    
}
