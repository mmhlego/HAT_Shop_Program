package Model;

public class Employee extends User {
    public EmployeeMode Mode;
    public String ID;

    public static String GenerateID() {
        return "";
    }

    public static int ModeToInt(EmployeeMode u) {
        switch (u) {
        case ASSISTANT:
            return 0;
        case ACCOUNTANT:
            return 1;
        case QUALITYCONTROL:
            return 2;
        case REGULAR:
            return 3;
        case SUPPLIER:
            return 3;
        case STOREKEEPER:
            return 3;
        }
        return -1;
    }

    public static EmployeeMode IntToMode(int u) {
        switch (u) {
        case 0:
            return EmployeeMode.ASSISTANT;
        case 1:
            return EmployeeMode.ACCOUNTANT;
        case 2:
            return EmployeeMode.QUALITYCONTROL;
        case 3:
            return EmployeeMode.REGULAR;
        case 4:
            return EmployeeMode.SUPPLIER;
        case 5:
            return EmployeeMode.STOREKEEPER;
        }
        return null;
    }
}

enum EmployeeMode {
    ASSISTANT, ACCOUNTANT, QUALITYCONTROL, REGULAR, SUPPLIER, STOREKEEPER
}
