package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataController.CustomUUID;

public class Shipping {
	public String OrderId, ID;
	public int Status;
	public long Fee;
	public LocalDate Date;

	public Shipping(String orderId, int status, long fee, LocalDate date) {
		OrderId = orderId;
		Status = status;
		Fee = fee;
		Date = date;
	}

	public static long generateFee(int amount) {
		return amount * 3500;
	}

	public static String GenerateID() {
		LocalDateTime dt = LocalDateTime.now();
		String date = dt.format(DateTimeFormatter.ofPattern("YYMMdd"));
		String id = CustomUUID.Create(6);

		return "HS-" + date + id;
	}
}
