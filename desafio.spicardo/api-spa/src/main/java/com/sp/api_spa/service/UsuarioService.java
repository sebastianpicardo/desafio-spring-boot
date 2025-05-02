package com.sp.api_spa.service;

import com.sp.api_spa.entity.Usuario;
import com.sp.api_spa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null);
    }
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
}
