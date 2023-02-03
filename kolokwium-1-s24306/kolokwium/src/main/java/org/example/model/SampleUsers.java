package main.java.org.example.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class SampleUsers {

    public static List<User> listOfUsers = List.of(
            new User("clark_kent", LocalDateTime.now().minusYears(2), false, 3),
            new User("batman-1", LocalDateTime.now().minusMonths(4), true, 3),
            new User("joker12", LocalDateTime.now().minusMonths(46), true, 3),
            new User("harlejka", LocalDateTime.now().minusMonths(14), true, 3),
            new User("blackmantha", LocalDateTime.now().minusMonths(8), true, 3),
            new User("aquaman", LocalDateTime.now().minusMonths(11), true, 3),
            new User("robin12", LocalDateTime.now().minusMonths(1), true, 3)
    );

    static {
        listOfUsers.forEach(user->user.setRole(getRole()));
    }

    static Role getRole(){
        var random = new Random().nextInt(6);
        switch(random)
        {
            case 0: return Role.USER;
            case 1: return Role.VIP;
            case 2: return Role.ADMIN;
            case 3: return Role.ROOT;
            case 4: return Role.INTERNAL;
            default:  return Role.ANONYMOUS;

        }
    }
}
