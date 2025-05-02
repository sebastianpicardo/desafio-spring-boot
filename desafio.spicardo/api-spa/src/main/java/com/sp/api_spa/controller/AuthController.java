package com.sp.api_spa.controller;

import com.sp.api_spa.entity.Usuario;
import com.sp.api_spa.security.JwtUtil;
import com.sp.api_spa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        // Busca el usuario por username
        Usuario usuarioDB = usuarioService.findByUsername(user.getUsername());

        // Valida que el usuario  exista y que el password coincida
        if (usuarioDB != null && usuarioDB.getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(usuarioDB.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
