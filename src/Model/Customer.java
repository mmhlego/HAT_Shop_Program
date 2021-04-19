package Model;

import DataController.CustomUUID;

public class Customer extends User {
	public CustomerMode Mode;
	public long Value;
	public String ID;

	public Customer(String firstName, String lastName, String username, String passeord, String phone, String email,
			CustomerMode mode, long value, String iD) {
		super(firstName, lastName, username, passeord, phone, email);
		Mode = mode;
		Value = value;
		ID = iD;
	}

	public static String GenerateID() {
		return "HC-" + CustomUUID.Create(10);
	}

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

	public enum CustomerMode {
		REGULAR, PREMIUM, REGULARBANNED, PREMIUMBANNED
	}
}
