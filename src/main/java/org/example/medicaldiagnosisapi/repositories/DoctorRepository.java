package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
