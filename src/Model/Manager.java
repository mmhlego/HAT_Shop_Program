package Model;

import DataController.CustomUUID;

public class Manager extends User {

    public static String GenerateID() {
        return "HM-" + CustomUUID.Create(4);
    }
}
