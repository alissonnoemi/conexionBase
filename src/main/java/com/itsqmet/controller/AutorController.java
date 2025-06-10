package com.itsqmet.controller;

import com.itsqmet.entity.Autor;
import com.itsqmet.entity.Libro;
import com.itsqmet.repository.AutorRepositorio;
import com.itsqmet.service.AutorServicio;
import com.itsqmet.service.LibroServicio;
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
public class AutorController {
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private LibroServicio libroServicio;

    //leer los libros
    @GetMapping("/autor")
    public String listarAutor( Model model){
        List<Autor> autor = autorServicio.mostrarAutor();
        model.addAttribute("autor",autor);
        return "pages/listaAutor";
    }
    //Insertar un Nuevo Libro
    @GetMapping("/formularioAutor")
    public String formularioAutor(Model model){
        model.addAttribute("autor", new Autor());

        return "pages/formularioAutor";
    }
    @PostMapping("/guardar-autor")
    public String guardarAutor(Autor autor){
        autorServicio.GuardarAutor(autor);
        return "redirect:/autor";
    }
    //Actualizar Libro
    @GetMapping("/editar-autor/{id}")
    public String actualizarAutor(@PathVariable Long id, Model model){
        Optional<Autor> autor = autorServicio.buscarAutorPorId(id);
        model.addAttribute("autor", autor);
        return "pages/formularioAutor";
    }
    //Eliminar Libro
    @GetMapping("/eliminar-autor/{id}")
    public String eliminarLibro(@PathVariable Long id){
        autorServicio.eliminarAutor(id);
        return "redirect:/libros";
    }
    //Buscar libros por autor
    @GetMapping ("/autor/{id}")
    public String obtenerLibrosPorAutor(@PathVariable Long id, Model model){
       Autor autor= autorServicio.obtenerAutorConLibros(id);
       List<Libro> librosAutor = libroServicio.buscarLibroAutor(autor.getId());
       model.addAttribute("librosAutor", librosAutor);
       model.addAttribute("autor", autor);
       return "pages/listaAutorLibro";
    }
}
