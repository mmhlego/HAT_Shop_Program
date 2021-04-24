package Controller;

public class UserController {
    public static final UserMode Mode = UserMode.Customer;

    public static enum UserMode {
        Customer, Employee, Manager;
    }
}
