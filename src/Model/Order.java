package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DataController.CustomUUID;

public class Order {
    String OwnerID, OrderID;
    OrderStatus status;
    String[] Products;
    int[] Amounts;
    long TotalValue;

    public static String GenerateID() {
        LocalDateTime dt = LocalDateTime.now();
        String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
        String id = CustomUUID.Create(4);

        return "HO-" + date + id;
    }

    public static int ModeToInt(OrderStatus u) {
        switch (u) {
        case PENDING:
            return 0;
        case SENDING:
            return 1;
        case FINISHED:
            return 2;
        }
        return -1;
    }

    public static OrderStatus IntToMode(int u) {
        switch (u) {
        case 0:
            return OrderStatus.PENDING;
        case 1:
            return OrderStatus.SENDING;
        case 2:
            return OrderStatus.FINISHED;
        }
        return null;
    }

    public enum OrderStatus {
        PENDING, SENDING, FINISHED
    }
}
