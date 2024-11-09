# Medical Diagnosis API

The **Medical Diagnosis API** is a comprehensive application designed to manage medical appointments, test analyses, and medical diagnoses. Spearheaded by Antonio Quispe, this project focuses on integrating artificial intelligence to enhance medical diagnostics and streamline the management of patient medical records.

## DER - Data-modeling

Inside the resources directory is the class diagram and data modeling

## Configuration

To run this API, ensure you meet the following prerequisites:

### Prerequisites

- **Java Development Kit (JDK) 17 or higher**
- **Maven** for dependency management and build processes
- **MySQL** or any database compatible with Spring Boot JPA
- **Postman** (optional, for API route testing)

### Database Setup

1. Create a database in MySQL named `ia_diagnosis_db`.
2. Configure the connection properties in the `application.properties` or `application.yml` file as follows:

   ```yaml
   spring.datasource.url=jdbc:mysql://localhost:3306/ia_diagnosis_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Authentication:** Spring Security has been implemented for authentication. Ensure you configure appropriate roles and users in the `application.properties` file for testing or production environments.

### Execution

Compile and run the application with the following command in the project's root directory:

```bash
mvn spring-boot:run
```

## Technologies Used

- **Java 17**
- **Spring Boot** (including Web, JPA, and Security modules)
- **Hibernate** for Object-Relational Mapping (ORM)
- **MySQL** as the primary database
- **Spring Security** for authentication and authorization
- **Postman** (recommended for API testing)
- **ModelMapper** for entity and DTO conversion
- **Maven** for dependency management

## Controller Structure and Routes

The controller structure is organized by main entities, each with its corresponding routes. Below is the general structure and examples of routes:

### Controllers and Routes

- **PatientController**
  - `GET /patients`: Retrieve all patients
  - `POST /patients`: Create a new patient
  - `GET /patients/{id}`: Retrieve details of a patient by ID

- **DoctorController**
  - `GET /doctors`: Retrieve all doctors
  - `POST /doctors`: Create a new doctor
  - `GET /doctors/{id}`: Retrieve details of a doctor by ID

- **AppointmentController**
  - `GET /appointments`: Retrieve all appointments
  - `POST /appointments`: Create a new appointment
  - `PUT /appointments/{id}`: Update an appointment by ID
  - `DELETE /appointments/{id}`: Delete an appointment by ID

- **MedicalTestController**
  - `GET /medical-tests`: Retrieve all medical tests
  - `POST /medical-tests`: Create a new medical test
  - `GET /medical-tests/{id}`: Retrieve details of a medical test by ID

- **DiagnosisController**
  - `GET /diagnoses`: Retrieve all diagnoses
  - `POST /diagnoses`: Create a new diagnosis
  - `GET /diagnoses/{id}`: Retrieve details of a diagnosis by ID

Each controller utilizes dedicated services and data repositories to facilitate scalability and maintainability of the codebase.

## Future Work

1. **AI Integration in Diagnostics:** Integrate an artificial intelligence engine to enhance the accuracy of medical diagnoses based on test results.
2. **Detailed Medical History:** Expand each patient's medical history to include comprehensive and detailed records.
3. **Advanced Authentication and Authorization:** Extend Spring Security configuration to support entity-level roles and permissions.
4. **Frontend Integration:** Develop a reactive frontend for real-time access and management of the API.
5. **Documentation and Automated Testing:** Create documentation using Swagger and implement unit and integration tests.

## Resources

- **Spring Boot Documentation:** [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- **MySQL Documentation:** [https://dev.mysql.com/doc/](https://dev.mysql.com/doc/)
- **Postman Documentation:** [https://www.postman.com/](https://www.postman.com/)
- **Spring Security Guide:** [https://spring.io/guides/topicals/spring-security-architecture](https://spring.io/guides/topicals/spring-security-architecture)

## Team Members

- **Antonio Quispe** - Lead Developer and Project Owner

---

# About routes

## Appointment

- Create - To create new Appointment its necessary to have a Patient and Doctor created first. 
    - Depending of appointment type will be necessary create only diagnosis or a medical_test with a diagnosis if not exit yet.
- Read - To read an Appointment is neccesary introduced id param to get the Appoinment. To read all Appointments is only neccesary call method.
- Update - To update an Appointment it can only change the date and time of an Appointment, then appointmentStatus will change to "Rescheduled".
- Delete - To delete an Appointment, a logical deletion will be performed, changing the AppointmentStatus to CANCELED.

## Patient

- Create - To create new Patient its necessary to have a MedicalRecord created first
- Read - To read an Patient is neccesary introduced id param to get the Patient. To read all Patients is only neccesary call method.
- Update - To update an Patient it can only change the biological sex of an Appointment and day of birth.
    - To update name is neccesary to have admin role.

## Diagnosis

- Create - To create new Diagnosis its necessary to have an Appointment created first, from this can to obtein MedicalRecord that is necessary created before too.
- Update - To update a Diagnosis it can on

## MedicalRecord

- Read - Only can read a MedicalRecord in specific through MedicalRecordId

## MedicalTest

- Read - To read an specific MedicalTest is necessary MedicalTestId, and it can only read MedicalTest result and type if medicalTestStatus is RESULT_AVAIBLE.
- Update - To update a MedicalTest it can only add resultTest, when this varible is changed medicalTestStatus will set on RESULT_AVAIBLE

---
