package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DataController.CustomUUID;

public class Transaction {

    public static String GenerateID() {
        LocalDateTime dt = LocalDateTime.now();
        String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
        String id = CustomUUID.Create(4);

        return "HT-" + date + id;
    }
}
