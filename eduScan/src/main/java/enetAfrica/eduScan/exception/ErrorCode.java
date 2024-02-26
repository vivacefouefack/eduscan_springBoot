package enetAfrica.eduScan.exception;

public enum ErrorCode {
    
    ACCOUNTEXECUTIVE_NOT_FOUND(1000),
    ACCOUNTEXECUTIVE_NOT_VALID(1001);
    
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
