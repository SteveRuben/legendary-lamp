package org.abodah.preiskeys.domain.user.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.abodah.preiskeys.domain.base.BaseEntity;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "APP_ROLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Role extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id") )
    private Set<Privilege> privileges;

    @Temporal(TemporalType.DATE)
    private Date created_at;
    @Temporal(TemporalType.DATE)
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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
