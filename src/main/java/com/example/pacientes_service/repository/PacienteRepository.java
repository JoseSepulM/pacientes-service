package com.example.pacientes_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pacientes_service.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}