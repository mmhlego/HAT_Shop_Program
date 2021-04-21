package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataController.CustomUUID;
import Model.Customer.CustomerMode;

public class Shipping {
	public String OrderId, ID;
	public int Status;
	public long Fee;
	public LocalDate Date;

	public Shipping(String orderId, int status, long fee, LocalDate date, String id) {
		OrderId = orderId;
		Status = status;
		Fee = fee;
		Date = date;
		ID = id;
	}

	public static long generateFee(int amount, CustomerMode mode) {
		return (mode.equals(CustomerMode.REGULAR)) ? amount * 3500 : 0;
	}

	public static String GenerateID() {
		LocalDateTime dt = LocalDateTime.now();
		String date = dt.format(DateTimeFormatter.ofPattern("YYMMdd"));
		String id = CustomUUID.Create(6);

		return "HS-" + date + id;
	}

	public void printDetails() {
		System.out.println("===============Shipping=================");
		System.out.println("order id = " + OrderId);
		System.out.println("status = " + Status);
		System.out.println("fee = " + Fee);
		System.out.println("date = " + Date);

	}
}
