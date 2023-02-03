package main.java.org.example;

import main.java.org.example.model.ClassInitiator;
import main.java.org.example.model.Role;
import main.java.org.example.model.SampleUsers;
import main.java.org.example.model.User;
import main.java.org.example.model.creators.UserCreator;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy. Życzę powodzenia :)");
        var users = SampleUsers.listOfUsers;
        User user = new User("s24306_DawidHoffmeister", LocalDateTime.now(), true, 5);
        UserCreator userC = new UserCreator();
        userC.assignRoleToUser(user, Role.VIP);
        ClassInitiator userInitiator = new ClassInitiator(User.class);
        userInitiator.initiateObject();
    }

    public static double getAverageRatingOfActiveVipUsers()
    {
        List<User> users = SampleUsers.listOfUsers;
        users
        return 0;
    }

    public static void deactivateInternalUsersLastSeenYearAgo(){}
}

