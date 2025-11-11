package users;

public class IncorrectUsernameOrPasswordException extends Exception {
    IncorrectUsernameOrPasswordException(String message) {
        super(message);
    }
}
