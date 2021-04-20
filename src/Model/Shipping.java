package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DataController.CustomUUID;

public class Shipping {

    public String ID;
    public int Status;
    public long Fee;
    public LocalDate Date;

    public static String GenerateID() {
        LocalDateTime dt = LocalDateTime.now();
        String date = dt.format(DateTimeFormatter.ofPattern("YYMMdd"));
        String id = CustomUUID.Create(6);

        return "HS-" + date + id;
    }
}
