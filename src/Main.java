import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] command = new String[] {""}; // new String[] {""} is to prevent NullPointerException

        System.out.println("Welcome to some system");

        while (!command[0].equals("exit")) {
            System.out.print(">>> ");
            command = CommandFormat.commandFormat(scanner.nextLine());
            Commands.runCom(command);
        }
    }
}