package com.example.pacientes_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pacientes_service.model.PacienteHeartCheck;

public interface PacienteHeartCheckRepository extends JpaRepository<PacienteHeartCheck, Long>{
    
}
