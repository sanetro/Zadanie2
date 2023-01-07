package pl.edu.wszib.store.paints.database;

import pl.edu.wszib.store.paints.model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class UserDB {
    private ArrayList <User> users = new ArrayList<User>();
    private static final UserDB instance = new UserDB();

    private UserDB() {
        users.add(new User("admin", "0133b400150530550fa65944da6edcd3", User.Role.ADMIN));
        users.add(new User("user", "f6ce65abb67736636d7a63cd22e10dcf", User.Role.USER));
    }

    public User findByLogin(String login) {

        User user = users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst().orElse(null);
        if (user == null)
            return null;
        else return user;

    }

    public void addUser(User user) {
        users.add(user);
    }

    public String checkRoleToAdmin(String login) {
        if (this.findByLogin(login) != null) {
            if (this.findByLogin(login).getRole() == User.Role.ADMIN) {
                return "1";
            }
            this.findByLogin(login).setRole(User.Role.ADMIN);
            return "0";
        }
        return "2";
    }

    public static UserDB getInstance() {
        return instance;
    }
}
