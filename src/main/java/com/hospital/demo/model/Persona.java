package com.hospital.demo.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Persona extends BaseModel{

    @NotBlank(message = "El nombre se encuentra vacio")
    private String nombre;

    @NotBlank(message = "El apellido paterno se encuentra vacio")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno se encuentra vacio")
    private String apellidoMaterno;

}
