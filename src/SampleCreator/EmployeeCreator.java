package SampleCreator;

import java.util.ArrayList;
import java.util.Random;

import DataController.DataAdder;
import Model.Employee;
import Model.Employee.EmployeeMode;

public class EmployeeCreator {
	private static Random random = new Random(System.currentTimeMillis());

	public EmployeeCreator() {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Pouya", "Afraz", "pouya", "pouya", EmployeeMode.ASSISTANT, "09222855759",
				"pouyaafraz@gmail.com", Employee.GenerateID(EmployeeMode.ASSISTANT)));

		employees.add(new Employee("Mohammad", "Hejazi", "mmhlego", "mmhlego", EmployeeMode.ASSISTANT, "09146501380",
				"mmhlego@gmail.com", Employee.GenerateID(EmployeeMode.ASSISTANT)));

		employees.add(new Employee("Kamyab", "Tabani", "CyberGhost", "HAT_Cyber", EmployeeMode.ASSISTANT, "09146559128",
				"k.tabani82@gmail.com", Employee.GenerateID(EmployeeMode.ASSISTANT)));

		for (int i = 0; i < 4; i++) {
			String[] name = randomName();
			employees.add(new Employee(name[0], name[1], "ACCOUNTANT" + (i + 1), "ACCOUNTANT" + (i + 1),
					EmployeeMode.ACCOUNTANT, GeneratePhoneNumber(), RandomMail("ACCOUNTANT" + (i + 1)),
					Employee.GenerateID(EmployeeMode.ACCOUNTANT)));
		}

		for (int i = 0; i < 5; i++) {
			String[] name = randomName();
			employees.add(new Employee(name[0], name[1], "QUALITYCONTROL" + (i + 1), "QUALITYCONTROL" + (i + 1),
					EmployeeMode.QUALITYCONTROL, GeneratePhoneNumber(), RandomMail("QUALITYCONTROL" + (i + 1)),
					Employee.GenerateID(EmployeeMode.QUALITYCONTROL)));
		}

		for (int i = 0; i < 8; i++) {
			String[] name = randomName();
			employees.add(new Employee(name[0], name[1], "REGULAR" + (i + 1), "REGULAR" + (i + 1), EmployeeMode.REGULAR,
					GeneratePhoneNumber(), RandomMail("REGULAR" + (i + 1)), Employee.GenerateID(EmployeeMode.REGULAR)));
		}

		for (int i = 0; i < 5; i++) {
			String[] name = randomName();
			employees.add(new Employee(name[0], name[1], "SUPPLIER" + (i + 1), "SUPPLIER" + (i + 1),
					EmployeeMode.SUPPLIER, GeneratePhoneNumber(), RandomMail("SUPPLIER" + (i + 1)),
					Employee.GenerateID(EmployeeMode.SUPPLIER)));
		}

		for (int i = 0; i < 5; i++) {
			String[] name = randomName();
			employees.add(new Employee(name[0], name[1], "STOREKEEPER" + (i + 1), "STOREKEEPER" + (i + 1),
					EmployeeMode.STOREKEEPER, GeneratePhoneNumber(), RandomMail("STOREKEEPER" + (i + 1)),
					Employee.GenerateID(EmployeeMode.STOREKEEPER)));
		}

		int j = 1;
		for (Employee employee : employees) {
			System.out.println("----------------------------Employee number: " + (j) + "-----------------------------");
			addEmployee(employee);
			j++;
		}
	}

	public static String randAdress() {
		String[] regions = { "Zafaranieh", "Sahand", "Abresan", "Shahnaz", "Maralan" };
		String[] alleys = { "Shargi", "Gharbi" };

		return "Tabriz, " + regions[random.nextInt(regions.length)] + ", " + Integer.toString(random.nextInt(20))
				+ "om " + alleys[random.nextInt(2)] + ", Pelak" + Integer.toString(random.nextInt(60));
	}

	private static String RandomMail(String s) {
		String mail = s;

		String[] prov = { "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com" };
		mail += prov[random.nextInt(prov.length)];

		return mail;
	}

	private String[] randomName() {
		String[] name = new String[2];
		if (random.nextBoolean()) {
			name[0] = englishFirstNames[random.nextInt(englishFirstNames.length)];
			name[1] = englishLastNames[random.nextInt(englishLastNames.length)];
		} else {
			name[0] = persianFirstNames[random.nextInt(persianFirstNames.length)];
			name[1] = persianLastNames[random.nextInt(persianLastNames.length)];
		}
		return name;
	}

	private static String[] englishFirstNames = { "Ahura", "Ashkan", "Armin", "Afshin", "Aria", "Ario", "Arman",
			"Ahmed", "Armin", "Arash", "Ahoora", "Arvand", "Afrasiab", "Anoushirevan", "Avesta", "Abtin", "Arshia",
			"Arshiya", "Ardeshir", "Artin", "Arvin", "Arya", "Aryan", "Hashem", "Bahman", "Bijan", "Babak", "Bahram",
			"Bardia" };
	private static String[] persianFirstNames = { "بصیر", "بشیر", "بهنام", "بنیامین", "فرهاد", "فربد", "فرخ", "فرشید",
			"فرزاد", "فریدون", "فرشاد", "ماندانا", "مهشید", "مهتا", "مهتاب", "مریم", "مهرگان", "مینا", "مژگان",
			"منیژه" };

	private static String[] englishLastNames = { "Aria", "Avesta", "Azimi", "Davani", "Darvishi", "Dehdari",
			"Dehkordi Esfahani", "Dabiri", "Hanifnejad", "Hakimi", "Hashemi", "Hedayati", "Homayoun", "Hooshang",
			"Houshian", "Afraz", "Tabani", "Hejazi", "Jahandar", "Jahangir", "Jahanshah", "Jamshidi", "Kabiri",
			"Kazemi", "Khadem", "Kordbacheh", "Kermanshahchi", "Kordfahimi", ",Kordmihani", "Kordestanifar" };
	private static String[] persianLastNames = { "کشاورز", "خیری", "خراسانی", "خرم", "خرمدین", "مدنی", "مزدکی",
			"موسویان", "مزدانی", "مهرگان", "مازندرانی", "مکری", "میشدر", "مبصری", "محسن", "پیرانشهری", "پهلوی", "پریا",
			"پیشدر", "پارسی" };

	private static String GeneratePhoneNumber() {
		String phoneNumber = "09";

		for (int i = 0; i < 9; i++) {
			phoneNumber += Integer.toString(random.nextInt(10));
		}

		return phoneNumber;
	}

	private void addEmployee(Employee e) {
		DataAdder.AddEmployee(e.FirstName, e.LastName, e.Username, e.Password, Employee.ModeToInt(e.Mode), e.Phone,
				e.Email, e.ID);
		// e.printDetails();
	}
}
