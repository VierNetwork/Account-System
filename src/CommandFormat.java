import java.util.ArrayList;

public class CommandFormat {

    public static String[] commandFormat(String command) {
        ArrayList<String> args = new ArrayList<>();
        int indexHold = 0, indexHold2;

        indexHold2 = command.indexOf(" ");
        args.add(command.substring(indexHold, (indexHold2 != -1? indexHold2 : command.length() - 1)));

        while (indexHold2 != -1) {
            indexHold2++;
            indexHold = indexHold2;

            try {
                if (command.substring(indexHold).startsWith("\"")) {
                    indexHold2 = command.indexOf("\"", indexHold + 1);
                    args.add(command.substring(indexHold, indexHold2));
                } else {
                    indexHold2 = command.indexOf(" ", indexHold + 1);
                    if (indexHold2 == -1) {
                        args.add(command.substring(indexHold));
                    } else {
                        args.add(command.substring(indexHold, indexHold2));
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("You forgot to close string argument with (\")");
            }
        }
        return args.toArray(new String[0]);
    }
}
