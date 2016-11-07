package ua.kiev.prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 11/2/2016.
 */
public class UserList {
    private static UserList userList = new UserList();
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("mezz", "mezz"));
        users.add(new User("test", "test"));
    }
    private UserList() {
    }

    public static UserList getInstance() {
        return userList;
    }

    public boolean check(String login, String password)
    {
        for (User user: users
             ) {
            if (user.getLogin().equals(login)&& user.getPassword().equals(password)) return true;

        }

        return false;
    }

    public User getUserbyLogin(String login)
    {
        for (User user: users) {

            if (user.getLogin().equals(login)) return user;

        }

        return null;
    }


}
