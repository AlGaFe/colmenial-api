package com.proyecto.colmenial.model;

        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import org.hibernate.annotations.IndexColumn;
        import org.springframework.data.annotation.CreatedDate;
        import org.springframework.data.jpa.domain.support.AuditingEntityListener;
        import java.io.Serializable;
        import java.util.Date;
        import javax.persistence.*;
@Entity
@Table(name = "apuntes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"fecha"}, allowGetters = true)
public class Apuntes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    @Temporal(TemporalType.DATE)

    private Date fecha;

    private String asignatura;

    private double precio;

    private int creador;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    private int valoracion;

    private String titulo;

    private String imagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCreador() {
        return creador;
    }

    public void setCreador(int creador) {
        this.creador = creador;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}