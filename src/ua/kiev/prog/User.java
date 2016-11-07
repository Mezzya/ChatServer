package ua.kiev.prog;

/**
 * Created by andre on 11/2/2016.
 */
public class User {
    private String login;
    private String password;
    private boolean online;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
