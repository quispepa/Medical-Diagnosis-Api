package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
