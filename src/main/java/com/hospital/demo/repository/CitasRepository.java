package com.hospital.demo.repository;

import com.hospital.demo.model.Citas;
import com.hospital.demo.model.Doctor;
import com.hospital.demo.model.Paciente;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitasRepository extends GenericRepository<Citas> {

    @Query(value = "SELECT * FROM citas WHERE ((?1 is null OR ?2 is null) or hora_inicio BETWEEN ?1 AND ?2)" +
            "AND ((?3 IS null)OR(id_consultorio=?3))" +
            "AND ((?4 IS null)OR(id_doctor=?4))"
    , nativeQuery = true)
    List<Citas> findByCriteria(LocalDateTime dateInicio, LocalDateTime datefin, Long idConsultorio, Long idDoctor);

    @Query(value = "SELECT * FROM citas WHERE" +
            "(hora_inicio BETWEEN ?1 AND ?2) " +
            "AND (hora_fin BETWEEN ?1 AND ?2)" +
            "AND (id_consultorio = ?3)" +
            "AND ((?4 IS null)OR(id != ?4))"
            , nativeQuery = true)
    List<Citas> findByTimeBetweenAndConsultorio(LocalDateTime horaInicio,LocalDateTime horaFin,Long idConsultorio, Long idCita);

    @Query(value = "SELECT * FROM citas WHERE" +
            "(hora_inicio BETWEEN ?1 AND ?2) " +
            "AND (hora_fin BETWEEN ?1 AND ?2)" +
            "AND (id_doctor = ?3)" +
            "AND ((?4 IS null)OR(id != ?4))"
            , nativeQuery = true)
    List<Citas> findByTimeBetweenAndDoctor(LocalDateTime horaInicio,LocalDateTime horaFin,Long idConsultorio, Long idDoctor);

    @Query(value = "SELECT * FROM citas WHERE" +
            "(hora_inicio BETWEEN ?1 AND ?2) " +
            "AND (hora_fin BETWEEN ?1 AND ?2)" +
            "AND (id_doctor = ?3)" +
            "AND ((?4 IS null)OR(id != ?4))"
            , nativeQuery = true)
    List<Citas> findByDoctorAndHoraFinBetween(LocalDateTime horaInicio,LocalDateTime horaFin,Long idDoctor,Long IdCita);

    @Query(value = "SELECT * FROM citas WHERE" +
            "(hora_inicio BETWEEN ?1 AND ?2) " +
            "AND (hora_fin BETWEEN ?1 AND ?2)" +
            "AND (id_paciente = ?3)" +
            "AND ((?4 IS null)OR(id != ?4))"
            , nativeQuery = true)
    List<Citas> findByTimeBetweenAndPaciente(LocalDateTime horaInicio,LocalDateTime horaFin,Long idPaciente, Long idCita);

}
