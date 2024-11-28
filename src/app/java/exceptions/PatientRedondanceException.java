package exceptions;

public class PatientRedondanceException extends RuntimeException {
    public PatientRedondanceException(String message) {
        super(message);
    }
}
