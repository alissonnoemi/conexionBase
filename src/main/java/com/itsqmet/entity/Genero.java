package com.itsqmet.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    @OneToMany( mappedBy = "genero")
    private List<Libro> libros;

}
