import users.Account;
import users.SignSys;

import java.util.Scanner;

public class Main {

    public static Account account = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] command = new String[]{""}; // new String[] {""} is to prevent NullPointerException

        System.out.println("Welcome to some system");

        while (!command[0].equals("exit")) {
            System.out.print(">>> ");
            try {
                command = CommandFormat.commandFormat(scanner.nextLine());
            } catch(StringIndexOutOfBoundsException e){
                System.err.println("You forgot to close string argument with (\")");
            }

            try {
                switch (command[0]) {
                    case "test" -> test(command);
                    case "exit" -> exit();
                    case "signin" -> account = SignSys.signIn(command[1], command[2]);
                    case "signup" -> account = SignSys.signUp();
                }
            } catch (users.IncorrectUsernameOrPasswordException | users.AccountIsBannedException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public static void test(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void exit() {
        System.out.println("Program is shutting down. Thanks for testing the Accounts System!");
    }

}