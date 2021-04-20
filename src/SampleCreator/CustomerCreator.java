package SampleCreator;

import java.time.LocalDate;
import java.util.Random;

import DataController.DataAdder;
import DataController.ProductChecker;
import Model.Customer;
import Model.Order;
import Model.Product;
import Model.Shipping;

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
			String firstName;
			String lastName;
			if (random.nextBoolean()) {
				firstName = persianFirstNames[random.nextInt(persianFirstNames.length)];
				lastName = persianLastNames[random.nextInt(persianLastNames.length)];
			} else {
				firstName = englishFirstNames[random.nextInt(englishFirstNames.length)];
				lastName = englishLastNames[random.nextInt(englishLastNames.length)];
			}
			String id = Customer.GenerateID();
			String phoneNumber = phoneNumber();
			// System.out.println(firstName + " " + lastName + " " + phoneNumber);
			DataAdder.AddCustomer(firstName, lastName, firstName + random.nextInt(9999),
					firstName + lastName + random.nextInt(9999), "0914" + phoneNumber,
					firstName + " " + lastName + "@gmail.com", "Tabriz", 0, random.nextInt(1), id);
			// DataAdder.AddOrder(OwnerID, Status, Products, Amounts, TotalValue, OrderID);
		}
		return true;
	}

	String[] englishFirstNames = { "Ahura", "Ashkan", "Armin", "Afshin", "Aria", "Ario", "Arman", "Ahmed", "Armin",
			"Arash", "Ahoora", "Arvand", "Afrasiab", "Anoushirevan", "Avesta", "Abtin", "Arshia", "Arshiya", "Ardeshir",
			"Artin", "Arvin", "Arya", "Aryan", "Hashem", "Bahman", "Bijan", "Babak", "Bahram", "Bardia" };
	String[] persianFirstNames = { "بصیر", "بشیر", "بهنام", "بنیامین", "فرهاد", "فربد", "فرخ", "فرشید", "فرزاد",
			"فریدون", "فرشاد", "ماندانا", "مهشید", "مهتا", "مهتاب", "مریم", "مهرگان", "مینا", "مژگان", "منیژه" };

	String[] englishLastNames = { "Aria", "Avesta", "Azimi", "Davani", "Darvishi", "Dehdari", "Dehkordi Esfahani",
			"Dabiri", "Hanifnejad", "Hakimi", "Hashemi", "Hedayati", "Homayoun", "Hooshang", "Houshian", "Afraz",
			"Tabani", "Hejazi", "Jahandar", "Jahangir", "Jahanshah", "Jamshidi", "Kabiri", "Kazemi", "Khadem",
			"Kordbacheh", "Kermanshahchi", "Kordfahimi", ",Kordmihani", "Kordestanifar" };
	String[] persianLastNames = { "کشاورز", "خیری", "خراسانی", "خرم", "خرمدین", "مدنی", "مزدکی", "موسویان", "مزدانی",
			"مهرگان", "مازندرانی", "مکری", "میشدر", "مبصری", "محسن", "پیرانشهری", "پهلوی", "پریا", "پیشدر", "پارسی" };

	private String phoneNumber() {
		String phoneNumber;
		Random random = new Random();
		phoneNumber = String.valueOf(random.nextInt(8999999) + 1000000);

		return phoneNumber;
	}

	private void orderMaker(String id, int s) {
		Random random = new Random();
		int make = random.nextInt();
		boolean first = true;
		if (make % 5 != 0) {
			for (int i = 0; i < random.nextInt(4) + 1; i++) {
				if (first) {
					Product product = ProductChecker.LoadALlProducts()
							.get(random.nextInt(ProductChecker.LoadALlProducts().size()));
					int amount = random.nextInt(4) + 1;
					DataAdder.AddOrder(id, 0, product.Name, String.valueOf(amount),
							Product.getTotalValue(product, amount), Order.GenerateID());
					first = false;
				} else {
					Product product = ProductChecker.LoadALlProducts()
							.get(random.nextInt(ProductChecker.LoadALlProducts().size()));
					int amount = random.nextInt(4) + 1;
					int status = random.nextInt(1) + 1;
					String orderId = Order.GenerateID();
					DataAdder.AddOrder(id, status, product.Name, String.valueOf(amount),
							Product.getTotalValue(product, amount), orderId);
					if (status == 1) {
						DataAdder.AddShipping(orderId, 0, (s == 0) ? Shipping.generateFee(amount) : 0, LocalDate.now());
					}
					DataAdder.AddTransaction(id, Product.getTotalValue(product, amount), LocalDate.now(), orderId);
				}
			}
		}

	}
}
