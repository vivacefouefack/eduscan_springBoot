package enetAfrica.eduScan.exception;

public enum ErrorCode {
    
    ACCOUNTEXECUTIVE_NOT_FOUND(1000),
    ACCOUNTEXECUTIVE_NOT_VALID(1001),

    AGENDA_NOT_FOUND(2000),
    AGENDA_NOT_VALID(2001),

    INSTITUTION_NOT_FOUND(3000),
    INSTITUTION_NOT_VALID(3001),

    PROSPECTION_NOT_FOUND(4000),
    PROSPECTION_NOT_VALID(4001),

    VISIT_NOT_FOUND(5000),
    VISIT_NOT_VALID(5001);
    
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
