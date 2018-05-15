package com.proyecto.colmenial.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "gradosasignaturas")
@EntityListeners(AuditingEntityListener.class)
public class GradosAsignaturas implements Serializable {
    @Id
    private String asignatura;

    private int grado;


    public String getAsignaturas() {
        return asignatura;
    }

    public void setAsignaturas(String asignaturas_codigo) {
        this.asignatura = asignatura;
    }

    public int getGrados() {
        return grado;
    }

    public void setGrados(int grados_id) {
        this.grado = grado;
    }


}