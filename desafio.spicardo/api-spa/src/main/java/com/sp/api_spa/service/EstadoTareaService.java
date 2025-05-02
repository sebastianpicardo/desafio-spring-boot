package com.sp.api_spa.service;

import com.sp.api_spa.entity.EstadoTarea;
import com.sp.api_spa.repository.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoTareaService {
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    public List<EstadoTarea> findAll() {
        return estadoTareaRepository.findAll();
    }
    
    public Optional<EstadoTarea> findById(Long id) {
        return estadoTareaRepository.findById(id);
    }
}
