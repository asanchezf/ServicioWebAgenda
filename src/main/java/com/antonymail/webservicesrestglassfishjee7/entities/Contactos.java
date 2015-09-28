/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonymail.webservicesrestglassfishjee7.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


//BB..DD.Agenda. Tabla contactos...

//GET
//http://localhost:8080/WebServicesRESTGlassFishJEE7/webresources/contacto--Devuelve todos
//http://localhost:8080/WebServicesRESTGlassFishJEE7/webresources/contacto/count--Devuelve el número total
//http://localhost:8080/WebServicesRESTGlassFishJEE7/webresources/contacto/3--Devuelve el serverdeId:3



@Entity
@Table(name = "contactos", catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c"),
    @NamedQuery(name = "Contactos.findById", query = "SELECT c FROM Contactos c WHERE c.id = :id"),
    @NamedQuery(name = "Contactos.findByNombre", query = "SELECT c FROM Contactos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contactos.findByApellidos", query = "SELECT c FROM Contactos c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Contactos.findByDireccion", query = "SELECT c FROM Contactos c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Contactos.findByTelefono", query = "SELECT c FROM Contactos c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contactos.findByEmail", query = "SELECT c FROM Contactos c WHERE c.email = :email"),
    @NamedQuery(name = "Contactos.findByIdCategoria", query = "SELECT c FROM Contactos c WHERE c.idCategoria = :idCategoria"),
    @NamedQuery(name = "Contactos.findByObservaciones", query = "SELECT c FROM Contactos c WHERE c.observaciones = :observaciones"),

    @NamedQuery(name = "Contactos.findByAndroidID", query = "SELECT c FROM Contactos c WHERE c.AndroidID = :AndroidID"),
    @NamedQuery(name = "Contactos.findByOwner", query = "SELECT c FROM Contactos c WHERE c.owner = :owner")
})


public class Contactos implements Serializable {
    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    
   
    @Column(name = "AndroidID", nullable = false)
    private Integer AndroidID;
    @Basic(optional = false)
    @NotNull
    
    
    @Size(min = 1, max = 45)
    @Column(name = "Nombre", nullable = false, length = 45)
    
    private String nombre;
    @Size(max = 45)
    
    @Column(name = "Apellidos", length = 45)
    private String apellidos;
    @Size(max = 45)
    
    @Column(name = "Direccion", length = 45)
    private String direccion;
    @Size(max = 45)
    
    @Column(name = "Telefono", length = 45)
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    
    @Column(name = "Email", length = 45)
    private String email;
    
    @Column(name = "Id_Categoria")
    private Integer idCategoria;
    @Size(max = 45)
    
    @Column(name = "Observaciones", length = 45)
    private String observaciones;

     @Column(name = "Owner", nullable = false, length = 45)
    private String owner;
     
    
    public Contactos() {
    }

    
    public Contactos(Integer id) {
        this.id = id;
    }

    public Contactos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Contactos(Integer id, Integer AndroidID, String nombre, String apellidos, String direccion, String telefono, String email, Integer idCategoria, String observaciones, String owner) {
        this.id = id;
        this.AndroidID = AndroidID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.idCategoria = idCategoria;
        this.observaciones = observaciones;
        this.owner = owner;
    }
  
    

    //<editor-fold defaultstate="collapsed" desc="METHODS GETTER">
    
      

    public Integer getId() {
        return id;
    }

    public Integer getAndroidID() {
        return AndroidID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    public String getOwner() {
        return owner;
    } 
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="METHODS SETTER">
    public void setId(Integer id) {
        this.id = id;
    }
    
      public void setAndroidID(Integer AndroidID) {
        this.AndroidID = AndroidID;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
     public void setOwner(String owner) {
        this.owner = owner;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EQUALS 6 HASHCODE">
   @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.AndroidID);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.idCategoria);
        hash = 89 * hash + Objects.hashCode(this.owner);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contactos other = (Contactos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.AndroidID, other.AndroidID)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        return true;
    }
//</editor-fold>

    

  

    
    
    
    
    
    
}
