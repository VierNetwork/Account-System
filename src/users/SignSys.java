package users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignSys {
    // Accounts
    static ArrayList<Account> accounts = new ArrayList<>();
    // Pattern for forbidden symbols
    static Pattern pattern = Pattern.compile("\\W");
    static Matcher matcher;
    static Scanner scanner = new Scanner(System.in);

    public static boolean findAcc(String username) {
        boolean doesContains = false;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                doesContains = true;
                break;
            }
        }
        return doesContains;
    }

    public static Account findAcc(String username, String password) throws IncorrectUsernameOrPasswordException {
        Account account = null;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                account = accounts.get(i);
                break;
            }
        }
        try {
            if (account.getPassword().equals(password)) {
                return account;
            } else {
                throw new IncorrectUsernameOrPasswordException("Incorrect password");
            }
        } catch (NullPointerException | IncorrectUsernameOrPasswordException e) {
            throw new IncorrectUsernameOrPasswordException("Incorrect username or password");
        }
    }

    public static Account signUp() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        // Does not allow username with forbidden symbols
        matcher = pattern.matcher(username);
        while (true) {
            if (matcher.find()) {
                System.err.println("Username must contain only latin letters, digits or underscore character.");
            } else if (findAcc(username)) {
                System.err.println("This username is already taken.");
            } else {
                break;
            }
            username = scanner.nextLine();
            matcher = pattern.matcher(username);
        }

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        // The same, but there is password instead
        matcher = pattern.matcher(password);
        while (matcher.find()) {
            System.err.println("Password must contain only latin letters, digits or underscore character.");
            password = scanner.nextLine();
            matcher = pattern.matcher(password);
        }

        // Creating an account
        accounts.add(new Account(accounts.size() - 1, name, username, password));
        System.out.println("Account has been created.");
        return accounts.get(accounts.size() - 1);
    }

    public static Account signIn(String username, String password) throws IncorrectUsernameOrPasswordException, AccountIsBannedException{
        Account account = null;

        try {
            account = findAcc(username, password);
        } catch (IncorrectUsernameOrPasswordException e) {
            throw new IncorrectUsernameOrPasswordException("Incorrect username or password");
        }

        if (account.getIsBanned()) {
            throw new AccountIsBannedException("Your account is banned");
        }
        return account;
    }
}

