package org.abodah.preiskeys.domain.document.types;

public enum EDocumentType {
    Curriculum("CV"), Recommendation("Recommendation"), Others("Others");
    final String code;
    EDocumentType(String code) {
        this.code = code;
    }
}
