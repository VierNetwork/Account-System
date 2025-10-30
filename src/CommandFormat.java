import java.util.ArrayList;

public class CommandFormat {

    public static String[] commandFormat(String command) {
        ArrayList<String> args = new ArrayList<>();
        int indexHold = 0, indexHold2;

        indexHold2 = command.indexOf(" ");
        args.add(command.substring(indexHold, indexHold2));

        while (indexHold2 < command.length()) {
            indexHold2++;
            indexHold = indexHold2;

            if (command.substring(indexHold).startsWith("\"")) {
                indexHold2 = command.indexOf("\"", indexHold + 1);
                args.add(command.substring(indexHold, indexHold2));
            } else {
                indexHold2 = command.indexOf(" ", indexHold + 1);
                args.add(command.substring(indexHold, indexHold2));
            }
        }
        return args.toArray(new String[0]);
    }
}
