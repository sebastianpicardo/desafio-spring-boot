package com.sp.api_spa.service;

import com.sp.api_spa.dto.TareaDTO;
import com.sp.api_spa.entity.Tarea;
import com.sp.api_spa.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstadoTareaService estadoTareaService;
    
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }
    
    public Tarea fromDTO(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setId(dto.getId());
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setUsuario(usuarioService.findById(dto.getUsuarioId()).orElse(null));
        tarea.setEstado(estadoTareaService.findById(dto.getEstadoId()).orElse(null));
        return tarea;
    }

    public TareaDTO toDTO(Tarea tarea) {
        TareaDTO dto = new TareaDTO();
        dto.setId(tarea.getId());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setUsuarioId(tarea.getUsuario().getId());
        dto.setEstadoId(tarea.getEstado().getId());
        dto.setEstadoNombre(tarea.getEstado().getNombre());
        return dto;
    }
}
