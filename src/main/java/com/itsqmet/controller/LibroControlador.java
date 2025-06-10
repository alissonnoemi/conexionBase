package com.itsqmet.controller;

import com.itsqmet.entity.Autor;
import com.itsqmet.entity.Libro;
import com.itsqmet.service.AutorServicio;
import com.itsqmet.service.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;
    @Autowired
    private AutorServicio autorServicio;

    //Leer los libros
    @GetMapping("/libros")
    public String listarLibros(@RequestParam (name="buscarLibro",required = false,defaultValue = "")
                                    String buscarLibro, Model model){
        List <Libro> libros = libroServicio.buscarPorTitulo(buscarLibro);
        model.addAttribute("buscarLibro",buscarLibro);
        model.addAttribute("libros",libros);
        return "pages/listaLibros";
    }
    //Insertar un Nuevo Libro
    @GetMapping("/formularioLibro")
    public String formularioLibro(Model model){
        model.addAttribute("libro", new Libro());
        //Pasar los autores desde el servicio autor al formulario
        List<Autor>autores = autorServicio.mostrarAutor();
        model.addAttribute("autores", autores);

        return "pages/formularioLibro";
    }
    @PostMapping("/guardar-libro")
    public String guardarLibro(Libro libro){
        libroServicio.GuardarLibro(libro);
        return "redirect:/libros";
    }
    //Actualizar Libro
    @GetMapping("/editar-libro/{id}")
    public String actualizarLibro(@PathVariable Long id, Model model){
        Optional<Libro> libro = libroServicio.buscarLibroId(id);
        model.addAttribute("libro", libro);
        //Pasar los autores desde el servicio autor al formulario pero mas corto
        model.addAttribute("autores", autorServicio.mostrarAutor());
        return "pages/formularioLibro";
    }
    //Eliminar Libro
    @GetMapping("/eliminar-libro/{id}")
    public String eliminarLibro(@PathVariable Long id){
         libroServicio.eliminarLibro(id);
         return "redirect:/libros";
    }

}
