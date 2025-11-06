public class Commands {

    // #UNFINISHED; Using to recognize the commands
    public static void runCom(String[] args) {
        switch (args[0]) {
            case "test" -> test(args);
            case "exit" -> exit();
        }
    }

    private static void test(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void exit() {
        System.out.println("Program is shutting down. Thanks for testing the Accounts System!");
    }
}
