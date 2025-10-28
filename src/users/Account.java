package users;

public class Account {

    private String name;
    private String username;
    private String password;

    public Account(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

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
}
