package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DataController.CustomUUID;

public class Transaction {
	public String FromID, ID;
	public long Amount;
	public LocalDate Date;

	public Transaction(String fromId, long amount, LocalDate date, String id) {
		super();
		FromID = fromId;
		this.Amount = amount;
		this.Date = date;
		this.ID = id;
	}

	public static String GenerateID() {
		LocalDateTime dt = LocalDateTime.now();
		String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
		String id = CustomUUID.Create(4);

		return "HT-" + date + id;
	}

	public void printDetails() {
		System.out.println("===========transactions===================");
		System.out.println("from id = " + FromID);
		System.out.println("total value =" + Amount);
		System.out.println("date = " + Date);
		System.out.println("id =" + ID);
	}
}
