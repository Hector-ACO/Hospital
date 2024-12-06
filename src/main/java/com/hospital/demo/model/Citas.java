package com.hospital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Citas extends BaseModel{

    @NotNull(message = "El doctor de la cita se encuentra vacio")
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @NotNull(message = "El paciente de la cita se encuentra vacio")
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @NotNull(message = "Se requiere el consultorio de la cita")
    @ManyToOne
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @NotNull(message = "Se requiere el horario de inicio la cita")
    private LocalDateTime horaInicio;

    @NotNull(message = "Se requiere el horario finalizacion de la cita")
    private LocalDateTime HoraFin;

}
