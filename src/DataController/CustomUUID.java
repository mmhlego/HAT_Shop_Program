package DataController;

import java.util.UUID;

public class CustomUUID {
    public static String Create(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}
