package com.hospital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="doctores")
public class Doctor extends Persona {

    @NotNull(message = "Se requiere la especialidad del doctor")
    @ManyToOne
    @JoinColumn(name = "especialidad")
    private Especialidad especialidad;

}
