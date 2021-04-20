package Model;

import java.time.*;
import java.time.format.DateTimeFormatter;
import DataController.CustomUUID;

public class Transaction {

    public String FromID, ID;
    public long Amount;
    public LocalDate Date;

    public static String GenerateID() {
        LocalDateTime dt = LocalDateTime.now();
        String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
        String id = CustomUUID.Create(4);

        return "HT-" + date + id;
    }
}
