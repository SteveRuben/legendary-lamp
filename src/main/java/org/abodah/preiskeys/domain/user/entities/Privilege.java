package org.abodah.preiskeys.domain.user.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.abodah.preiskeys.domain.base.BaseEntity;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "APP_PRIVILEGE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Privilege extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    private Date created_at;
    private Date updated_at;

    @PrePersist
    public void prePersist() {
        created_at = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updated_at = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return getId().equals(privilege.getId()) && name.equals(privilege.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
