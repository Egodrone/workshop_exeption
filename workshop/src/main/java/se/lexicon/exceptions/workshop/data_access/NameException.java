package se.lexicon.exceptions.workshop.data_access;



public class NameException extends RuntimeException {

    private CustomError errors;



    public NameException(CustomError errors){

        super(errors.getErrorMessage());
        this.errors = errors;
    }



    public CustomError getErrors() {
        return errors;
    }



}
