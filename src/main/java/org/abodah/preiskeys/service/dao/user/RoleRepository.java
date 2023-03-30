package org.abodah.preiskeys.service.dao.user;

import org.abodah.preiskeys.domain.user.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
