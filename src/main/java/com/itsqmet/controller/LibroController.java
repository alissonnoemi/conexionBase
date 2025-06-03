package com.itsqmet.controller;

import com.itsqmet.entidad.Libro;
import com.itsqmet.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroController {
    @Autowired
    private LibroServicio libroServicio;

    //leer
    @GetMapping("/libros")
    public String listarlibros(@RequestParam(name = "buscarLibro", required = false, defaultValue = "")
                               String buscarLibro, Model model) {
        List<Libro>libros= libroServicio.buscarLibroPorTitulo(buscarLibro);
        model.addAttribute("libros", libros);
        model.addAttribute("buscarLibro", buscarLibro);
        return "pages/listaLibros";

    }
    //Insertar nuevo libro
    @GetMapping ("/formularioLibro")
    public String formularioLibro(Model model){
        model.addAttribute("libro", new Libro());
        return "pages/formularioLibro";

    }
    @PostMapping ("/guardarLibro")
    public String crearLibro(Libro libro){
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }
    //Actualizar libro
    @GetMapping("/editarLibro/{id}")
    public String actualizarLibro(@PathVariable Long id, Model model){
        Optional<Libro> libro= libroServicio.buscarLibroPorId(id);
        model.addAttribute("libro", libro);
        return "pages/formularioLibro";
    }
    //Eliminar libro
    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable Long id, Model model){
        libroServicio.eliminarLibro(id);
        return "redirect:/libros";
    }
}