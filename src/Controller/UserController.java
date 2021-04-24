package Controller;

public class UserController {
    public static UserMode Mode = UserMode.Customer;

    public static enum UserMode {
        Customer, Employee, Manager;
    }
}
