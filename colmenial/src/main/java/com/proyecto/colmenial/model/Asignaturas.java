package com.proyecto.colmenial.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "asignaturas")
@EntityListeners(AuditingEntityListener.class)
public class Asignaturas implements Serializable {
    @Id
    private String codigo;

    private String nombre;


    @ManyToMany(mappedBy="asignaturas")
    List<Grados> grados;

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

    public List<Grados> getGrados() {
        return grados;
    }

    public void setGrados(List<Grados> grados) {
        this.grados = grados;
    }
}