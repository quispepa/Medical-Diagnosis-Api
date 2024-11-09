package org.example.medicaldiagnosisapi.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.medicaldiagnosisapi.models.Role;
import org.example.medicaldiagnosisapi.models.User;
import org.example.medicaldiagnosisapi.repositories.RoleRepository;
import org.example.medicaldiagnosisapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    /**
     * Autowired UserRepository for database operations.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Autowired RoleRepository for database operations.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Saves a new role to the database
     *
     * @param role the role to be saved
     * @return the saved role
     */
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    /**
     * Adds a role to the user with the given username
     *
     * @param username the username of the user to add the role to
     * @param roleName the name of the role to be added
     */
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);

        // Retrieve the user and role objects from the repository
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        // Add the role to the user's role collection
        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);
    }
}
