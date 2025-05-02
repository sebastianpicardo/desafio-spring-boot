package com.sp.api_spa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.api_spa.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> { }