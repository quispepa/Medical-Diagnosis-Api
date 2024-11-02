package org.example.medicaldiagnosisapi.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.medicaldiagnosisapi.enums.DoctorSpecialty;
import org.example.medicaldiagnosisapi.models.Appointment;

import java.util.List;

public class DoctorResponse {
  @NotBlank
  private String doctorName;
  @NotNull
  private DoctorSpecialty doctorSpecialty;
}
