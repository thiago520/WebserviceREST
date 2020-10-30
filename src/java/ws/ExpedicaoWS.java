/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.ExpedicaoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.Expedicao;

/**
 * REST Web Service
 *
 * @author thiag
 */
@Path("Expedicao")
public class ExpedicaoWS {

   @Context
    private UriInfo context;

    /**
     * Creates a new instance of ExpedicaoWS
     */
    public ExpedicaoWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ExpedicaoWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "Teste webservice";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/expedicao")
    public String getExpedicao() throws ClassNotFoundException, SQLException{
        Gson g = new Gson();
        ExpedicaoDAO dao = new ExpedicaoDAO();
        List<Expedicao> expedicao = dao.getListaExpedicao();
        
        return g.toJson(expedicao);
        
    }
    
 /*   @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public boolean inserirExpedicao(String content) {
        Gson g = new Gson();
        Expedicao exp = (Expedicao) g.fromJson(content, Expedicao.class);
        
        ExpedicaoDAO dao = new ExpedicaoDAO();
        return dao.inserirExpedicao(exp);
    } */
    
 /*   @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deletar/{id}")
    public String deletarExpedicao(@PathParam("id")int id) {
        ExpedicaoDAO dao = new ExpedicaoDAO();
        if (dao.deletarExpedicao(id)) {
            return "true";
        } else {
            return "false";
        }
        
    } */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public boolean atualizarExpedicao(String content) {
        Gson g = new Gson();        
        Expedicao exp = (Expedicao) g.fromJson(content, Expedicao.class);
        
        ExpedicaoDAO dao = new ExpedicaoDAO();
        return dao.atualizarExpedicao(exp);
    } 

    /**
     * PUT method for updating or creating an instance of ExpedicaoWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
