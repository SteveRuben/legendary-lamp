package org.abodah.preiskeys.service.dao.user;

import org.abodah.preiskeys.domain.user.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
