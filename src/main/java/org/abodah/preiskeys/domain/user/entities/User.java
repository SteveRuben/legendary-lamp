package org.abodah.preiskeys.domain.user.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.abodah.preiskeys.domain.base.BaseEntity;
import org.abodah.preiskeys.domain.user.types.EUserType;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "APP_USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity<UUID> {

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    EUserType type;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String salt;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
    private Set<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
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
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPhoneNumber());
    }
}
