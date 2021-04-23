package Model;

import DataController.CustomUUID;

public class Employee extends User {
	public EmployeeMode Mode;
	public String ID;

	public Employee(String firstName, String lastName, String username, String passeord, EmployeeMode mode , String phone, String email
			, String id) {
		super(firstName, lastName, username, passeord, phone, email);
		Mode = mode;
		ID = id;
	}

	public static String GenerateID(EmployeeMode mode) {
		return "HE-" + Integer.toString(ModeToInt(mode)) + CustomUUID.Create(6);
	}

	public static int ModeToInt(EmployeeMode u) {
		switch (u) {
		case ASSISTANT:// 3
			return 0;
		case ACCOUNTANT:// 5
			return 1;
		case QUALITYCONTROL:// 5
			return 2;
		case REGULAR:// 10
			return 3;
		case SUPPLIER:// 8
			return 4;
		case STOREKEEPER:// 7
			return 5;
		}
		return -1;
	}

	public static EmployeeMode IntToMode(int u) {
		switch (u) {
		case 0:
			return EmployeeMode.ASSISTANT;
		case 1:
			return EmployeeMode.ACCOUNTANT;
		case 2:
			return EmployeeMode.QUALITYCONTROL;
		case 3:
			return EmployeeMode.REGULAR;
		case 4:
			return EmployeeMode.SUPPLIER;
		case 5:
			return EmployeeMode.STOREKEEPER;
		}
		return null;
	}

	public void printDetails() {
		System.out.println("==============Employee mode: " + Mode + "================");
		System.out.println("first name = " + FirstName);
		System.out.println("last name = " + LastName);
		System.out.println("username = " + Username);
		System.out.println("password = " + Password);
		System.out.println("phone = " + Phone);
		System.out.println("id = " + ID);

	}

	public enum EmployeeMode {
		ASSISTANT, ACCOUNTANT, QUALITYCONTROL, REGULAR, SUPPLIER, STOREKEEPER
	}
}