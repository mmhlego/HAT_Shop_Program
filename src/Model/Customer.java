package Model;

import java.util.ArrayList;

import DataController.CustomUUID;

public class Customer extends User {
	public CustomerMode Mode;
	public long Value;
	public String ID, Address;
	ArrayList<Order> orders = new ArrayList<>();

	public Customer(String firstName, String lastName, String username, String passeord, String phone, String email,
			String address, long value, CustomerMode mode,  String iD) {
		super(firstName, lastName, username, passeord, phone, email);
		Mode = mode;
		Address = address;
		Value = value;
		ID = iD;
	}

	public static String GenerateID() {
		return "HC-" + CustomUUID.Create(10);
	}

	public enum CustomerMode {
		REGULAR, PREMIUM, REGULARBANNED, PREMIUMBANNED;

		public static int ModeToInt(CustomerMode u) {
			switch (u) {
			case REGULAR:
				return 0;
			case PREMIUM:
				return 1;
			case REGULARBANNED:
				return 2;
			case PREMIUMBANNED:
				return 3;
			}
			return -1;
		}

		public static CustomerMode IntToMode(int u) {
			switch (u) {
			case 0:
				return CustomerMode.REGULAR;
			case 1:
				return CustomerMode.PREMIUM;
			case 2:
				return CustomerMode.REGULARBANNED;
			case 3:
				return CustomerMode.PREMIUMBANNED;
			}
			return null;
		}
	}

	public void PrintDetails() {
		System.out.println("================================Customer===============================================");
		System.out.println("F name : " + FirstName);
		System.out.println("L name : " + LastName);
		System.out.println("Username : " + Username);
		System.out.println("Pass : " + Password);
		System.out.println("Phone : " + Phone);
		System.out.println("EMail : " + Email);
		System.out.println("Address : " + Address);
		System.out.println("Value : " + Value);
		System.out.println("Mode : " + Mode.toString());
		System.out.println("ID : " + ID);
	}
}
