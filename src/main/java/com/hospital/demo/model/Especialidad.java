package com.hospital.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Especialidad extends BaseModel{

    @NotBlank(message = "El nombre de la especialidad se encuentra vacio")
    private String nombre;

}
