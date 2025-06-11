package com.itsqmet.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String direccion;
    //relacion con tarjeta de suscripcion
    @OneToOne (mappedBy = "usuario")
    private TarjetaSuscripcion tarjetaSuscripcion;
    //@ManyToMany
   // @JoinTable(name="prestamo",
    //joinColumns = @JoinColumn(name="usuario_id"),
    //inverseJoinColumns  =@JoinColumn(name="libro_id"))
    //private  List<Libro> libros;
    //relacion con prestamo
    @OneToMany (mappedBy = "usuario")
    private List<Prestamo> prestamos;




}
