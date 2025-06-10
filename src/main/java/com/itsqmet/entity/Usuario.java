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
    @OneToMany (mappedBy = "usuario", fetch = FetchType.LAZY)
    private List <Prestamo> prestamos;
    @OneToOne (mappedBy = "usuario")
    private TarjetaSuscripcion tarjetaSuscripcion;

}
