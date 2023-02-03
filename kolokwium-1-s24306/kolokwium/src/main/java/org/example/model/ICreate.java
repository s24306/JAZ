package main.java.org.example.model;

public interface ICreate <TObj extends IHaveRoles> {
    public TObj create();
    public void assignRoleToUser(User user, Role role);
}
