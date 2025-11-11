package users;

public class AccountIsBannedException extends Exception {
    AccountIsBannedException(String message) {
        super(message);
    }
}
