package com.example.pacientes_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pacientes_service.model.PacienteTemperatura;

public interface PacienteTemperaturaRepository extends JpaRepository<PacienteTemperatura, Long> {
    
}
