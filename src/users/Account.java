package users;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    private final int id;
    private String name;
    private String username;
    private String password;
    private boolean isBanned;
    private ArrayList<String> data = new ArrayList<>();

    public Account(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        isBanned = false;
    }

    public void use() {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        System.out.println("Welcome, ".concat(name));

        while(!command.equals("logout")) {
            System.out.print(">>> ");
            command = scanner.nextLine();

        }
    }

    // #UNFINISHED: Missing help function; Actions with account data.
    private void addData(String string) {
        data.add(string);
    }

    private void findData(String string) {
        System.out.println(data.get(data.indexOf(string)));
    }

    private void changeData (int id, String string) {
        data.set(id, string);
    }

    private void deleteData (int id) {
        data.remove(id);
    }

    private void accParams() {
        System.out.println("Name: " + getName());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }

    private void editAccParams(String field, String newData) {
        switch (field) {
            case "name" -> setName(newData);
            case "username" -> setUsername(newData);
            case "password" -> setPassword(newData);
            default -> throw new IllegalArgumentException("");
        }
    }

    // Getters and Setters
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected boolean getIsBanned() {
        return isBanned;
    }

    protected void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    private void setData(ArrayList<String> data) {
        this.data = data;
    }

    private void updateData (ArrayList<String> data) {
        SignSys.accounts.get(id).setData(data);
    }
}
