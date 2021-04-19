package Model;

import DataController.CustomUUID;

public class Manager extends User {

	public Manager(String firstName, String lastName, String username, String passeord, String phone, String email) {
		super(firstName, lastName, username, passeord, phone, email);
	}

	public static String GenerateID() {
		return "HM-" + CustomUUID.Create(4);
	}
}
