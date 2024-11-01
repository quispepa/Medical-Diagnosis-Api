CREATE TABLE patients (
                          patient_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          patient_name VARCHAR(255) NOT NULL,
                          patient_day_of_birth DATE NOT NULL,
                          patient_biological_sex varchar(255) NOT NULL
);
CREATE TABLE doctors (
                         doctor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         doctor_name VARCHAR(255) NOT NULL,
                         doctor_specialty varchar(255) NOT NULL
);
CREATE TABLE medical_records (
                                 medical_record_id BIGINT PRIMARY KEY,
                                 record_details TEXT,
                                 FOREIGN KEY (medical_record_id) REFERENCES patients(patient_id)
);
CREATE TABLE appointments (
                              appointment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              appointment_date_and_time DATETIME NOT NULL,
                              appointment_type VARCHAR(255) NOT NULL,
                              appointment_status VARCHAR(255) NOT NULL,
                              patient_id BIGINT NOT NULL,
                              doctor_id BIGINT NOT NULL,
                              FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
                              FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);
CREATE TABLE diagnoses (
                           diagnosis_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           diagnosis_identified_disease_by_ia VARCHAR(255),
                           diagnosis_identified_disease_by_doctor VARCHAR(255),
                           treatment_suggested_by_ia VARCHAR(255),
                           treatment_suggested_by_doctor VARCHAR(255),
                           diagnosis_approval_date_by_doctor DATE,
                           diagnosis_observations TEXT,
                           diagnosis_treatment_status VARCHAR(255) NOT NULL,
                           medical_record_id BIGINT NOT NULL,
                           appointment_id BIGINT NOT NULL,
                           FOREIGN KEY (medical_record_id) REFERENCES medical_records(medical_record_id),
                           FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);
CREATE TABLE medical_tests (
                               medical_test_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               result TEXT,
                               medical_test_type VARCHAR(255) NOT NULL,
                               medical_test_status VARCHAR(255) NOT NULL,
                               appointment_id BIGINT NOT NULL,
                               diagnosis_id BIGINT,
                               FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id),
                               FOREIGN KEY (diagnosis_id) REFERENCES diagnoses(diagnosis_id)
);
