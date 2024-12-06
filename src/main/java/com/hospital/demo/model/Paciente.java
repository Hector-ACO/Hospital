package com.hospital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="pacientes")
public class Paciente extends  Persona{
}
