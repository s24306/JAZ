package main.java.org.example.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UsersSearch implements IFindUsers{
    @Override
    public List<User> getUsersByUsername(List<User> users, String username) {
        return users.stream().filter(u -> u.getUsername().contains(username.toLowerCase())).toList();
    }

    @Override
    public void deactivateUsersSeenBefore(List<User> users, LocalDateTime lastSeen) {
        users.stream().filter(d -> d.getLastSeen().isBefore(lastSeen)).forEach(user -> user.setActive(false));
    }

    @Override
    public Map<Role, List<User>> groupByrole(List<User> users) {
        return users.stream().map(u -> u.getRole());
    }

    @Override
    public double getAverageRating(List<User> users) {
        return users.stream().mapToDouble(u -> u.getRating()).average().orElse(-1);
    }
}
