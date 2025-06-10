package com.itsqmet.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
   @ManyToOne
   @JoinColumn (name = "libro_id")
    private Libro libro;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;
}
