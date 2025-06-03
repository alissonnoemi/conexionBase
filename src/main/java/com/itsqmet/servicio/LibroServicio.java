package com.itsqmet.servicio;

import com.itsqmet.entidad.Libro;
import com.itsqmet.repositorio.libroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private libroRepositorio libroRepositorio;
    //Metodo mostrar libro
    public List<Libro> mostrarLibros(){
        return libroRepositorio.findAll();

    }
    //Buscar libro por titulo
    public List<Libro> buscarLibroPorTitulo(String buscarLibro){
        if(buscarLibro==null || buscarLibro.isEmpty()){
            return libroRepositorio.findAll();
        }else{
            return libroRepositorio.findByTituloContainingIgnoreCase(buscarLibro);
        }
    }
    //Buscar libro por id
    public Optional<Libro> buscarLibroPorId(Long id){
        return libroRepositorio.findById(id);
    }
    //Guardar libro
    public Libro guardarLibro(Libro libro){
        return libroRepositorio.save(libro);
    }
    //Eliminar libro
    public void eliminarLibro(Long id){
        libroRepositorio.deleteById(id);
    }
}
