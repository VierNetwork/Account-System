package users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignSys {
    // Accounts
    private static ArrayList<Account> accounts = new ArrayList<>();
    // Pattern for forbidden symbols
    static Pattern pattern = Pattern.compile("\\W");
    static Matcher matcher;
    static Scanner scanner = new Scanner(System.in);

    public static Account signUp() {
        Object[] usernames = accounts.stream().map(account -> account.getUsername()).toArray();
        String name = scanner.nextLine();
        String username = scanner.nextLine();

        // #UNFINISHED Does not allow username with forbidden symbols
        matcher = pattern.matcher(username);
        while (matcher.find() || ()) {
            System.out.println("В логине разрешено использовать только латинские буквы, цифры и знак подчёркивания.");
            username = scanner.nextLine();
            matcher = pattern.matcher(username);
        }

        String password = scanner.nextLine();

        // The same, but there is password instead
        matcher = pattern.matcher(password);
        while (matcher.find()) {
            System.out.println("В пароле разрешено использовать только латинские буквы, цифры и знак подчёркивания.");
            password = scanner.nextLine();
            matcher = pattern.matcher(password);
        }

    }
}
