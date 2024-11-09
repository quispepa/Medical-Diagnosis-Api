package org.example.medicaldiagnosisapi.dtos;

import lombok.Data;

/**
 * Data transfer object for passing information for adding a role to a user
 */
@Data
public class RoleToUserDTO {

    private String username;

    private String roleName;
}
