package SampleCreator;

import java.util.Random;

import DataController.DataAdder;
import Model.Customer;

public class CustomerCreator {
	public CustomerCreator() {
		// DataAdder,AddCustomer(FirstName, LastName, Username, Password, Phone, Email,
		// Address, Value, AccountMode, ID);
		// System.out.println(customerAdder(100));
	}

	public boolean customerAdder(int count) {
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			// System.out.println(Arrays.toString(firstNames()));
			// System.out.println(Arrays.toString(lastNames()));
			String firstName = firstNames()[random.nextInt(firstNames().length)];
			String lastName = lastNames()[random.nextInt(lastNames().length)];
			String phoneNumber = phoneNumber();
			// System.out.println(firstName + " " + lastName + " " + phoneNumber);
			DataAdder.AddCustomer(firstName, lastName, firstName + random.nextInt(9999),
					firstName + lastName + random.nextInt(9999), "0914" + phoneNumber,
					firstName + " " + lastName + "@gmail.com", "Tabriz", 0, random.nextInt(1), Customer.GenerateID());
		}
		return true;
	}

	private String[] firstNames() {
		String[] firstNames = { "Ahura", "Ashkan", "Armin", "Afshin", "Aria", "Ario", "Arman", "Ahmed", "Armin",
				"Arash", "Ahoora", "Arvand", "Afrasiab", "Anoushirevan", "Avesta", "Abtin", "Arshia", "Arshiya",
				"Ardeshir", "Artin", "Arvin", "Arya", "Aryan", "Hashem", "Bahman", "Bijan", "Babak", "Bahram", "Bardia",
				"Basir", "Bashir", "Behnam", "Benyamin", "Farhad", "Farbod", "Farrokh", "Farshid", "Farzad",
				"Feraydoon", "Farshad", "Mandana", "Mahshid", "Mahta", "Mahtab", "Maryam", "Mehregan", "Mina",
				"Mozhgan", "Manizheh" };
		return firstNames;
	}

	private String[] lastNames() {
		String[] lastNames = { "Aria", "Avesta", "Azimi", "Davani", "Darvishi", "Dehdari", "Dehkordi Esfahani",
				"Dabiri", "Hanifnejad", "Hakimi", "Hashemi", "Hedayati", "Homayoun", "Hooshang", "Houshian", "Afraz",
				"Tabani", "Hejazi", "Jahandar", "Jahangir", "Jahanshah", "Jamshidi", "Kabiri", "Kazemi", "Khadem",
				"Kordbacheh", "Kermanshahchi", "Kordfahimi", ",Kordmihani", "Kordestanifar", "Keshavarz", "Khezri",
				"Khorasani", "Khorram", "Khorramdin", "Madani", "Mazdaki", "Mousavian", "Mazdani", "Mehregan",
				"Mazandarani", "Mokri", "Mishdar", "Mobasseri", "Mohsen", "Piranshahri", "Pahlavi", "Paria", "Pishdar",
				"Parsi" };
		return lastNames;
	}

	private String phoneNumber() {
		String phoneNumber;
		Random random = new Random();
		phoneNumber = String.valueOf(random.nextInt(8999999) + 1000000);

		return phoneNumber;
	}

}
