package org.abodah.preiskeys.domain.base;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<T extends Serializable> {
    @Id
    T id;
}
