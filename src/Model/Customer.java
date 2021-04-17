package Model;

import DataController.CustomUUID;

public class Customer extends User {
    public CustomerMode Mode;
    public long Value;
    public String ID;

    public static String GenerateID() {
        return "HC-" + CustomUUID.Create(10);
    }

    public static int ModeToInt(CustomerMode u) {
        switch (u) {
        case REGULAR:
            return 0;
        case PREMIUM:
            return 1;
        case REGULARBANNED:
            return 2;
        case PREMIUMBANNED:
            return 3;
        }
        return -1;
    }

    public static CustomerMode IntToMode(int u) {
        switch (u) {
        case 0:
            return CustomerMode.REGULAR;
        case 1:
            return CustomerMode.PREMIUM;
        case 2:
            return CustomerMode.REGULARBANNED;
        case 3:
            return CustomerMode.PREMIUMBANNED;
        }
        return null;
    }

    public enum CustomerMode {
        REGULAR, PREMIUM, REGULARBANNED, PREMIUMBANNED
    }
}
