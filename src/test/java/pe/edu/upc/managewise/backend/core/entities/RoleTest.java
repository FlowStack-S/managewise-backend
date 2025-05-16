package pe.edu.upc.managewise.backend.core.entities;

import org.junit.jupiter.api.Test;
import pe.edu.upc.managewise.backend.iam.domain.model.entities.Role;
import pe.edu.upc.managewise.backend.iam.domain.model.valueobjects.Roles;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RoleTest {
    @Test
    void testGetStringNameReturnsEnumName() {
        Role role = new Role(Roles.ROLE_ADMIN);
        assertThat(role.getStringName()).isEqualTo("ROLE_ADMIN");
    }

    @Test
    void testGetDefaultRoleReturnsRoleUser() {
        Role defaultRole = Role.getDefaultRole();
        assertThat(defaultRole.getName()).isEqualTo(Roles.ROLE_USER);
    }

    @Test
    void testToRoleFromNameReturnsCorrectRole() {
        Role role = Role.toRoleFromName("ROLE_MODERATOR");
        assertThat(role.getName()).isEqualTo(Roles.ROLE_MODERATOR);
    }

    @Test
    void testValidateRoleSetReturnsSameListIfNotEmpty() {
        Role admin = new Role(Roles.ROLE_ADMIN);
        List<Role> roles = Role.validateRoleSet(List.of(admin));
        assertThat(roles).containsExactly(admin);
    }

    @Test
    void testValidateRoleSetReturnsDefaultIfEmpty() {
        List<Role> roles = Role.validateRoleSet(Collections.emptyList());
        assertThat(roles).containsExactly(Role.getDefaultRole());
    }

    @Test
    void testValidateRoleSetReturnsDefaultIfNull() {
        List<Role> roles = Role.validateRoleSet(null);
        assertThat(roles).containsExactly(Role.getDefaultRole());
    }
}
