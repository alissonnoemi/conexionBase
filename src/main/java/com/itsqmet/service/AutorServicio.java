package com.itsqmet.service;

import com.itsqmet.entity.Autor;
import com.itsqmet.entity.Libro;
import com.itsqmet.repository.AutorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    //Mostrar los autore
    public List<Autor> mostrarAutor(){
        return autorRepositorio.findAll();
    }

    //Buscar autor por ID
    public Optional<Autor> buscarAutorPorId(Long id){
        return  autorRepositorio.findById(id);

    }
    //Guardar Libro
    public  Autor GuardarAutor(Autor autor){
        return autorRepositorio.save(autor);
    }
    //Eliminar el Libro
    public void eliminarAutor(Long id){
        autorRepositorio.deleteById(id);
    }
    //Obtener autor con sus libros
    @Transactional
    public Autor obtenerAutorConLibros(Long id){
        Autor autor = autorRepositorio.findById(id).orElseThrow();
        return autor;
    }

}
