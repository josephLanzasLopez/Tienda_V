
package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author Joseph
 */
@Data
@Entity
@Table(name="cliente")

public class Cliente implements Serializable{
    
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idCliente; //Hibernet lo transforma en id_cliente
    String nombre;
    String apellidos;
    String correo;
    String telefono;

    public Cliente() {
        
    }

    public Cliente(String nombre, String apellidos, String correo, String telefon) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefon(String telefono) {
        this.telefono = telefono;
    }
    
}


