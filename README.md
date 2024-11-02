
# About entitys

## Appointment

- Create - To create new Appointment its necessary to have a Patient and Doctor created first.
- Read - To read an Appointment is neccesary introduced id param to get the Appoinment. To read all Appointments is only neccesary call method.
- Update - To update an Appointment it can only change the date and time of an Appointment, then appointmentStatus will change to "Rescheduled".

## Patient

- Create - To create new Patient its necessary to have a MedicalRecord created first
- Read - To read an Patient is neccesary introduced id param to get the Patient. To read all Patients is only neccesary call method.
- Update - To update an Patient it can only change the biological sex of an Appointment and day of birth.
    - To update name is neccesary to have admin role.

---

### Correct Creation of a `Patient` and its `MedicalRecord`

To create and save a `Patient` along with its related `MedicalRecord` in a `OneToOne` relationship, follow these steps:

1. Instantiate a `Patient`, setting basic data like name, birth date, and biological sex.
2. Instantiate a `MedicalRecord`.
3. Set up the bidirectional relationship between `Patient` and `MedicalRecord`:
    - Use `medicalRecord.setPatient(patient);` to assign the `Patient` to the `MedicalRecord`.
    - Use `patient.setMedicalRecord(medicalRecord);` to assign the `MedicalRecord` to the `Patient`.
4. Save the `Patient` using `patientRepository.save(patient);`. This will ensure that the `MedicalRecord` is also saved automatically due to the `CascadeType.ALL` configuration.

**Example:**

```java
Patient patient = new Patient("Jhon", LocalDate.of(1999, 9, 9), PatientBiologicalSex.MALE);
MedicalRecord medicalRecord = new MedicalRecord();
medicalRecord.setPatient(patient);
patient.setMedicalRecord(medicalRecord);
patientRepository.save(patient);
```

> **Reason:** This approach ensures that the `MedicalRecord` is created and saved along with the `Patient` in a single transaction, avoiding detached entity errors.

---
