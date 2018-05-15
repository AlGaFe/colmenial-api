package com.proyecto.colmenial.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "asignaturas")
@EntityListeners(AuditingEntityListener.class)
public class Asignaturas implements Serializable {
    @Id
    private String codigo;

    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}