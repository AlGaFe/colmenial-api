package com.proyecto.colmenial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "gradosuniversidad")
@EntityListeners(AuditingEntityListener.class)

public class GradosUniversidades implements Serializable {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="universidad")
    private int universidad;

    @Column(name="grado")
    private int grado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUniversidad() {
        return universidad;
    }

    public void setUniversidad(int universidad) {
        this.universidad = universidad;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }


}
