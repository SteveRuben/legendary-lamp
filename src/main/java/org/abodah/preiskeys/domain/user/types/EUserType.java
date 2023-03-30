package org.abodah.preiskeys.domain.user.types;

public enum EUserType {
    Anonymous("Anonymous"), Current("Current"), Administrator("Administrator");
    private final String code;
    private EUserType(String code ){
        this.code = code;
    }
}
