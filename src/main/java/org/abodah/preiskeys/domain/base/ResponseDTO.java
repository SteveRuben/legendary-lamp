package org.abodah.preiskeys.domain.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO <T>{
    T data;
    private int status;
    private String message;
}
