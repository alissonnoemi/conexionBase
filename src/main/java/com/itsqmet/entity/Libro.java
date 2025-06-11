package com.itsqmet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "Libros") //el table solo se pone si quiero ponerle otro nombre a la tabla
@Data
@NoArgsConstructor
public class Libro {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //esto hace que sea autoincrementable
    private long id;

     @Column (unique = true) //para que mi titulo sea unico
     private String titulo;
     private String editorial;
     private String paginas;
     private Double precio;
     private String autores;
     @ManyToOne
    @JoinColumn(name="id_autor")
    private Autor autor;
     //Relaciòn de varios  uno
     @ManyToOne
    @JoinColumn (name = "id_genero")
    private Genero genero;
     //@ManyToMany (mappedBy = "libros")
    //private List<Usuario> usuarios;
    //Relaciòn con libro
    @OneToMany (mappedBy = "libro")
    private List<Prestamo> prestamos;



}
