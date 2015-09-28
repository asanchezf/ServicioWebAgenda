/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonymail.webservicesrestglassfishjee7.service;

import com.antonymail.webservicesrestglassfishjee7.entities.Contactos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * http://localhost:8080/WebServicesRESTGlassFishJEE7/webresources/contactos
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    //Se modifica introduciendo el control de las transacciones...
    /*  public void create(T entity) {
    
    getEntityManager().persist(entity);
    }*/

    public String create(T entity) {
        
        try{
            
         //DA ERROR SI PONEMOS TRANSACCIONES....    
        //EntityManager em=getEntityManager();
        //em.getTransaction().begin();
        //em.persist(entity);
        //em.getTransaction().commit();
        //NECESITAMOS DEVOLVER EL ID DEL REGISTRO CREADO PARA QUE LO TRATE EL CLIENTE
        EntityManager em=getEntityManager();
        //getEntityManager().persist(entity);
        em.persist(entity);
        em.flush();
        em.refresh(entity);
        
        return "ok";
        
        }
        
        catch(Exception e){
        
            return e.getLocalizedMessage();
      }
       
    }
    
    
    //Se modifica introduciendo el control de las transacciones...
    /*public void edit(T entity) {
    getEntityManager().merge(entity);
    }*/
    
    public String edit(T entity) {
        
        try{
        
        //EntityManager em=getEntityManager();
        //em.getTransaction().begin();
        //em.merge(entity);
        //em.getTransaction().commit();
        
        
        getEntityManager().merge(entity);
        return "ok";
        
        
        }
        
        catch(Exception e){
            //Devolvemos el mensaje de error en el idioma en que se ejecute la app, si está disponible
            return e.getLocalizedMessage();
      }
    }
    
    //Se modifica introduciendo el control de las transacciones...
    /* public void remove(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
    }*/
    
    
    public String remove(T entity) {
        try{
        
        //EntityManager em=getEntityManager();
        //em.getTransaction().begin();
        //em.remove(em.merge(entity));    
        //em.getTransaction().commit();
        getEntityManager().remove(getEntityManager().merge(entity));
        return "ok";
        }
        
        catch(Exception e){
            //Devolvemos el mensaje de error en el idioma en que se ejecute la app, si está disponible
            return e.getLocalizedMessage();
      }
    }

    
    
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        
    }
    
    /////////////////////////////////////////////////////
    //Nuevo. Buscar por propietario:
    public List<T> findAllByOwner(String owner) {
        
        EntityManager em=getEntityManager();
        Query query=em.createNamedQuery("Contactos.findByOwner",Contactos.class);
        query.setParameter("owner", owner);
        return query.getResultList();
     }
    /////////////////////////////////////////////////////

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
