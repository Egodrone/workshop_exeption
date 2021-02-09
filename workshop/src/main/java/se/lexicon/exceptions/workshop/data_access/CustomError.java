package se.lexicon.exceptions.workshop.data_access;



public enum CustomError {

    NAME_EXIST(42, " Hey there, This female name already exist! Try another one! "),
    MALE_NAME_EXIST(46, " Hey there, Don't want to bother but this name already exist! "),
    LAST_NAME_EXIST(420, " Hey again, this lastname already exist ");

    private int errorCode;
    private String errorMessage;



    CustomError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }



    public int getErrorCode() {
        return errorCode;
    }



    public String getErrorMessage() {
        return errorMessage;
    }



}
