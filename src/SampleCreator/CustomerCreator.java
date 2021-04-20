package SampleCreator;

import java.util.ArrayList;
import java.util.Random;
import DataController.DataAdder;
import DataController.ProductChecker;
import Model.Customer;
import Model.Order;
import Model.Product;
import Model.Customer.CustomerMode;
import Model.Order.OrderStatus;

public class CustomerCreator {
	private static ArrayList<Product> allProducts = new ArrayList<Product>();

	public static void CustomerAdder(int count) {
		Random random = new Random(System.currentTimeMillis());

		allProducts = ProductChecker.LoadAllProducts();

		for (int i = 0; i < count; i++) {
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
			CustomerMode mode = (random.nextBoolean()) ? CustomerMode.REGULAR : CustomerMode.PREMIUM;

			Customer c = new Customer(firstName, lastName, "Customer" + Integer.toString(i),
					"Customer" + Integer.toString(i), GeneratePhoneNumber(),
					RandomMail("Customer" + Integer.toString(i)), "Tabriz", mode, 0, id);

			//.PrintDetails

			// System.out.println(firstName + " " + lastName + " " + phoneNumber);
			DataAdder.AddCustomer(c);

			if (random.nextBoolean()) {
				Order o = OrderMaker(id, OrderStatus.PENDING, random.nextInt(3) + 1);
				DataAdder.AddOrder(o);
			}

			for (i = 0; i < random.nextInt(5); i++) {
				Order o = OrderMaker(id, OrderStatus.FINISHED, random.nextInt(5) + 1);
				DataAdder.AddOrder(o);
			}

			// DataAdder.AddOrder(OwnerID, Status, Products, Amounts, TotalValue, OrderID);
		}
	}

	private static String RandomMail(String s) {
		String mail = s;
		Random random = new Random(System.currentTimeMillis());

		String[] prov = { "@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com" };
		mail += prov[random.nextInt(prov.length)];

		return mail;
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
		Random random = new Random(System.currentTimeMillis());

		for (int i = 0; i < 9; i++) {
			phoneNumber += Integer.toString(random.nextInt(10));
		}

		return phoneNumber;
	}

	private static Order OrderMaker(String id, OrderStatus status, int productCount) {
		Order o = new Order(id, Order.GenerateID(), status);

		Random random = new Random(System.currentTimeMillis());

		int len = allProducts.size();

		for (int i = 0; i < productCount; i++) {
			Product p = allProducts.get(random.nextInt(len));
			int amount = 1 + random.nextInt(5);

			o.addProduct(p, amount);
		}

		return o;
	}
}
