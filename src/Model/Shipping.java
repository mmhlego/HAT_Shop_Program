package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataController.CustomUUID;

public class Shipping {
	public String orderId;
	public int status;
	public long fee;
	public LocalDate date;

	public Shipping(String orderId, int status, long fee, LocalDate date) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.fee = fee;
		this.date = date;
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
