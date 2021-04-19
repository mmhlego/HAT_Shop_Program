package Model;

import DataController.CustomUUID;

public class Employee extends User {
	public EmployeeMode Mode;
	public String ID;

	public Employee(String firstName, String lastName, String username, String passeord, String phone, String email,
			EmployeeMode mode, String iD) {
		super(firstName, lastName, username, passeord, phone, email);
		Mode = mode;
		ID = iD;
	}

	public static String GenerateID(EmployeeMode mode) {
		return "HE-" + Integer.toString(ModeToInt(mode)) + CustomUUID.Create(6);
	}

	public static int ModeToInt(EmployeeMode u) {
		switch (u) {
		case ASSISTANT:
			return 0;
		case ACCOUNTANT:
			return 1;
		case QUALITYCONTROL:
			return 2;
		case REGULAR:
			return 3;
		case SUPPLIER:
			return 4;
		case STOREKEEPER:
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

	public enum EmployeeMode {
		ASSISTANT, ACCOUNTANT, QUALITYCONTROL, REGULAR, SUPPLIER, STOREKEEPER
	}
}