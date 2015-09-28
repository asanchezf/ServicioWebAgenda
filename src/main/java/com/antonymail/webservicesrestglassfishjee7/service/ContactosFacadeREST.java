/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonymail.webservicesrestglassfishjee7.service;

import com.antonymail.webservicesrestglassfishjee7.entities.Contactos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//Se ha cambiado el path para hacerlo más corto....
@Stateless
@Path("contactos")
public class ContactosFacadeREST extends AbstractFacade<Contactos> {
    @PersistenceContext(unitName = "com.antonymail_WebServicesRESTGlassFishJEE7_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
     //CREACION DE CADENA DE DEVOLUCION DE DATOS PARA UNIFICAR Y PLANTIFICAR LA RESPUESTA DE JSON--------------------------------
    private final String JSON_RESPONSE="{\"serverId\":%d, \"androidId\":%d, \"operacion\":\"%s\", \"resultado\":\"%s\"}";
    //---------------------------------------------------------------------------------------------------------------------------
    
    public ContactosFacadeREST() {
        super(Contactos.class);
    }

    
    
    //Se cambia el tipo de recurso que consume. Ahora solo será JSon. Por defecto viene también XML. Y se añade el tipo de recurso que produce. Será también Json
    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Contactos entity) {
        
        String resultado=super.create(entity);
        
        //devolvemos en formato jsonreponse: el id del servidor,el id de Android, la operacion realizada, y el resultado
        return String.format(JSON_RESPONSE,entity.getId(),entity.getAndroidID(),"INSERT",resultado);
    }

    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public String edit(@PathParam("id") Integer id, Contactos entity) {
        String resultado=super.edit(entity);
        
         //devolvemos en formato jsonreponse: el id del servidor,el id de Android, la operacion realizada, y el resultado
        return String.format(JSON_RESPONSE,entity.getId(),entity.getAndroidID(),"UPDATE",resultado);
    }

    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(@PathParam("id") Integer id) {
        String resultado=super.remove(super.find(id));
        
        String JSON_PARA_DELETE="{\"serverId\":%d, \"operacion\":\"%s\", \"resultado\":\"%s\"}";
        
        //La respuesta de remove será distinta pq no necesita tanta información de vuelta...
        return String.format(JSON_PARA_DELETE,id,"DELETE",resultado);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Contactos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    //////////////////////////////////////////////////////////////
    ///Nuevo.Para búsquedas por propietario
    
      @GET
    @Override
    @Path("propietario/{owner}")
    @Produces({"application/json"})
    public List<Contactos> findAllByOwner(@PathParam("owner")String owner) {
        
        return super.findAllByOwner(owner);
    }
    
    
    
    ///////////////////////////////////////////////////////////////
    
    @GET
    @Override
    @Produces({"application/json"})
    public List<Contactos> findAll() {
        return super.findAll();
    }

    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Contactos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
}
