package nl.hva.ewa.models;

public class ClientError {
    public static final String ALREADY_EXISTS = "ALREADY_EXISTS";
    public static final String NO_CHANGES_MADE = "NO_CHANGES_MADE";
    public static final String NO_COMPETENCES_FOUND = "NO_COMPETENCES_FOUND";
    public static final String NO_QUESTIONS_FOUND = "NO_QUESTIONS_FOUND";
    public static final String NO_STUDENTS_IN_GROUP = "NO_STUDENTS_IN_GROUP";
    public static final String NOT_ENOUGH_QUESTIONS = "NOT_ENOUGH_QUESTIONS";
    public static final String PROFILE_NOT_FOUND = "PROFILE_NOT_FOUND";
    public static final String RESULTS_NOT_FOUND = "RESULTS_NOT_FOUND";
    public static final String TOKEN_INVALID = "TOKEN_INVALID";
    public static final String TOKEN_UNSIGNED = "TOKEN_UNSIGNED";
    public static final String UNKNOWN_ERROR = "UNKNOWN";
    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
    public static final String WRONG_CREDENTIALS_ERROR = "WRONG_CREDENTIALS";
    public static final String WRONG_PARAMETERS_ERROR = "WRONG_PARAMETERS";
    public static final String LOGS_NOT_FOUND = "LOGS_NOT_FOUND";

    private String error;
    private String errorCode;

    public ClientError()
    {

    }

    public ClientError(String error,String errorCode)
    {
        this.error = error;
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
