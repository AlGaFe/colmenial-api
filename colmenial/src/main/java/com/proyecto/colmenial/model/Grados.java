


package com.proyecto.colmenial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "grados")
@EntityListeners(AuditingEntityListener.class)

public class Grados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToMany
    @JoinTable()
    private List<Universidades> universidades;

    @ManyToMany
    @JoinTable()
    private List<Asignaturas> asignaturas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Universidades> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<Universidades> universidades) {
        this.universidades = universidades;
    }


    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
