package com.itsqmet.entity;

import jakarta.persistence.*;

@Entity
public class TarjetaSuscripcion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private Number tipo;
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;
}
