package com.itsqmet.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(unique = true)
    private String titulo;
    private String editorial;
    private String paginas;
    private String precio;
}
