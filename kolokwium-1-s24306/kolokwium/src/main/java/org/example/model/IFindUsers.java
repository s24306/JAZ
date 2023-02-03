package main.java.org.example.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IFindUsers {
    public List<User> getUsersByUsername(List<User> users, String username);
    public void deactivateUsersSeenBefore(List<User> users, LocalDateTime lastSeen);
    public Map<Role, List<User>> groupByrole(List<User> users);
    public double getAverageRating(List<User> users);
}
