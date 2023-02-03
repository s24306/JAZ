package main.java.org.example.model.creators;

import main.java.org.example.model.ICreate;
import main.java.org.example.model.Role;
import main.java.org.example.model.User;

import java.time.LocalDateTime;
import java.util.Date;

public class UserCreator implements ICreate<User> {
    @Override
    public User create() {
        return new User("s24306_DawidHoffmeister", LocalDateTime.now(), true, 5);
    }

    @Override
    public void assignRoleToUser(User user, Role role) {
        user.setRole(role);
    }
}
