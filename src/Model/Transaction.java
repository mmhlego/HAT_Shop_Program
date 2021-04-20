package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataController.CustomUUID;

public class Transaction {
	String FromId;
	long value;
	LocalDate date;
	String id;

	public Transaction(String fromId, long value, LocalDate date, String id) {
		super();
		FromId = fromId;
		this.value = value;
		this.date = date;
		this.id = id;
	}

	public static String GenerateID() {
		LocalDateTime dt = LocalDateTime.now();
		String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
		String id = CustomUUID.Create(4);

		return "HT-" + date + id;
	}
}
