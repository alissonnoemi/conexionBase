package com.itsqmet.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String mostarLogin(){
        return "pages/UsuarioPag/Login";
    }
    @GetMapping ("/postLogin")
    public String redirigirPorRol(Authentication authentication) {
        // Verificar si el usuario está autenticado
        User usuario = (User) authentication.getPrincipal();
        String role = usuario.getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority())
                .findFirst()
                .orElse("");
        if (role.equals("ROLE_admin")) {
            return "redirect:/admin";
        } else if (role.equals("ROLE_bibliotecario")) {
            return "redirect:/autores";
        } else if(role.equals("ROLE_estudiante")){
            return "redirect:/libros";
        }
        return "redirect:/login?error=true";
    }
}
