package com.example.pacientes_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull(message = "El rut no debe ser nulo")
    @Size(max = 100, message = "El rut debe tener máximo 10 caracteres")
    private String RUT;

    @Size(min = 1, max = 1, message = "El dígito verificador debe tener 1 carácter")
    private String DV;

    @NotNull(message = "El nombre no puede estar en null")
    private String NOMBRE;

    @NotNull(message = "El apellido no puede estar en null")
    @Size(min = 5, max = 200, message = "El apellido debe encontrarse entre 5 y 200 caracteres")
    private String APELLIDO;

    @NotNull(message = "La edad no puede ser nula")
    @Size(min = 1, max = 100, message = "La edad debe ser mayor a 0")
    private int EDAD;

    // Getters y Setters

    public Long getID() {
        return ID;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getDV() {
        return DV;
    }

    public void setDV(String DV) {
        this.DV = DV;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public int getEDAD() {
        return EDAD;
    }

    public void setEDAD(int EDAD) {
        this.EDAD = EDAD;
    }
}
