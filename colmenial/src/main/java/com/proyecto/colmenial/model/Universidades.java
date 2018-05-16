package com.proyecto.colmenial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
@CrossOrigin(origins = "*")
@Entity
@Table(name = "universidades")
@EntityListeners(AuditingEntityListener.class)

public class Universidades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToMany(mappedBy = "universidades")
    private List<Grados> grados;

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
}

