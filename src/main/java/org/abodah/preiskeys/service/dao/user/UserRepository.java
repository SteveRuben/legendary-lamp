package org.abodah.preiskeys.service.dao.user;

import org.abodah.preiskeys.domain.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
