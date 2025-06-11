package com.itsqmet.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    //relacion con usuario
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;
    //relacion con libro
    @ManyToOne
    @JoinColumn (name = "libro_id")
    private Libro libro;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fechaPrestamo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fechaDevolucion;
}
