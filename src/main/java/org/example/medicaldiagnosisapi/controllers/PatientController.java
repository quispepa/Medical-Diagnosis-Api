package org.example.medicaldiagnosisapi.controllers;

import jakarta.validation.Valid;
import org.example.medicaldiagnosisapi.dtos.CreatePatientRequest;
import org.example.medicaldiagnosisapi.dtos.PatientResponse;
import org.example.medicaldiagnosisapi.dtos.UpdatePatientNameRequest;
import org.example.medicaldiagnosisapi.dtos.UpdatePatientRequest;
import org.example.medicaldiagnosisapi.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

  private final PatientService patientService;

  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping
  public ResponseEntity<List<PatientResponse>> getAllPatients(){
    List<PatientResponse> patientResponseList = patientService.getAllPaitents();
    return patientResponseList.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(patientResponseList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PatientResponse> getAllPatients(@PathVariable Long id){
    Optional<PatientResponse> patientResponseOptional = patientService.getPatient(id);
    return patientResponseOptional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid CreatePatientRequest createPatientRequest){
    Optional<PatientResponse> patientResponseOptional = patientService.createPatient(createPatientRequest);
    return patientResponseOptional.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @RequestBody @Valid UpdatePatientRequest updatePatientRequest){
    Optional<PatientResponse> patientResponseOptional = patientService.updatePatient(id,updatePatientRequest);
    return patientResponseOptional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

  /**
   * Endpoint only use to admin
   * @param id patientId to get Patient object to update
   * @param updatePatientName request that contains name to update
   * @return an ResponseEntity ok if patientId is correct, else an ResponseEntity not found
   */
  @PatchMapping("/updateName/{id}")
  public ResponseEntity<PatientResponse> updatePatientName(@PathVariable Long id, @RequestBody @Valid UpdatePatientNameRequest updatePatientName){
    Optional<PatientResponse> patientResponseOptional = patientService.updatePatientName(id, updatePatientName);
    return patientResponseOptional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }


}
