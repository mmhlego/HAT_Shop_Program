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

	public enum ShippingMode {
		PROVED, CLEARANCE, DELIVERYTOSENDER, CUSTOMERRECEIVED;

		public static double ModeToInt(ShippingMode u) {
			switch (u) {
			case PROVED:
				return 0;
			case CLEARANCE:
				return 1 / 4;
			case DELIVERYTOSENDER:
				return 3 / 4;
			case CUSTOMERRECEIVED:
				return 1;
			}
			return -1;
		}

		public static ShippingMode IntToMode(double u) {
			if (u == 0) {
				return ShippingMode.PROVED;
			} else if (u == 1 / 4) {
				return ShippingMode.CLEARANCE;
			} else if (u == 3 / 4) {
				return ShippingMode.DELIVERYTOSENDER;
			} else if (u == 1) {
				return ShippingMode.CUSTOMERRECEIVED;
			} else {
				return null;
			}

		}
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
