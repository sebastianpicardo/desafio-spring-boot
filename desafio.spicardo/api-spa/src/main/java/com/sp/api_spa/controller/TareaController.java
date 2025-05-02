package com.sp.api_spa.controller;

import com.sp.api_spa.dto.TareaDTO;
import com.sp.api_spa.entity.Tarea;
import com.sp.api_spa.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping(name = "listarTareas")
    @Operation(summary = "Listar todas las tareas")
    public ResponseEntity<?> listarTareas() {
        List<TareaDTO> tareas = tareaService.findAll()
                    .stream()
                    .map(tareaService::toDTO)
                    .toList();
        
        if (tareas.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No hay tareas disponibles");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

     
        return ResponseEntity.ok(tareas);
    }

    @PostMapping(name = "crearTarea")
    @Operation(summary = "Crear una nueva tarea")
    public TareaDTO crearTarea(@RequestBody TareaDTO tareaDTO) {
        Tarea tarea = tareaService.fromDTO(tareaDTO);
        return tareaService.toDTO(tareaService.save(tarea));
    }

    @PutMapping(value = "/{id}", name = "actualizarTarea")
    @Operation(summary = "Actualizar una tarea existente")
    public TareaDTO actualizarTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO) {
        Tarea tarea = tareaService.fromDTO(tareaDTO);
        tarea.setId(id);
        return tareaService.toDTO(tareaService.save(tarea));
    }

    @DeleteMapping(value = "/{id}", name = "eliminarTarea")
    @Operation(summary = "Eliminar una tarea por ID")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.deleteById(id);
    }
}