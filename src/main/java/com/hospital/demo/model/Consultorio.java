package com.hospital.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Consultorio extends BaseModel{

    @NotNull(message = "El numero del consultorio se encuentra vacio")
    private Integer numero;

    @NotNull(message = "El piso del consultorio se encuentra vacio")
    private Integer piso;

}
