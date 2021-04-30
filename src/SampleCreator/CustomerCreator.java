package SampleCreator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import DataController.DataAdder;
import DataController.ProductChecker;
import Model.Customer;
import Model.Customer.CustomerMode;
import Model.Order;
import Model.Order.OrderStatus;
import Model.Product;
import Model.Shipping;
import Model.Transaction;

public class CustomerCreator {
	private static ArrayList<Product> allProducts = new ArrayList<Product>();
	private static Random random = new Random(System.currentTimeMillis());

	public static void CustomerAdder(int count) {

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

			if (random.nextInt(20) == 0) {
				mode = CustomerMode.IntToMode(CustomerMode.ModeToInt(mode) + 2);
			}

			Customer c = new Customer(firstName, lastName, "Customer" + Integer.toString(i),
					"Customer" + Integer.toString(i), GeneratePhoneNumber(),
					RandomMail("Customer" + Integer.toString(i)), "Tabriz", 0, mode, id);

			// .PrintDetails

			// System.out.println(firstName + " " + lastName + " " + phoneNumber);
			//System.out.println(i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i
			//		+ "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i + "\t" + i
			//		+ "\t" + i);
			System.out.println("Created " + (i + 1) + " Customers");

			DataAdder.AddCustomer(c);

			if (random.nextBoolean()) {
				Order o = OrderMaker(id, OrderStatus.PENDING, random.nextInt(3) + 1, Order.GenerateID());
				DataAdder.AddOrder(o);
			} else {
				Order o = new Order(id, Order.GenerateID(), OrderStatus.PENDING);
				DataAdder.AddOrder(o);
			}

			Shipping shipping;
			if (random.nextBoolean()) {
				String orderId = Order.GenerateID();
				int amount = random.nextInt(3) + 1;
				Order o = OrderMaker(id, OrderStatus.SENDING, amount, orderId);
				DataAdder.AddOrder(o);
				long fee = Shipping.generateFee(amount, mode);
				LocalDate localDate = LocalDate.of(2016 + random.nextInt(6), random.nextInt(12) + 1,
						random.nextInt(28) + 1);
				shipping = new Shipping(orderId, 0, fee, localDate, Shipping.GenerateID());
				DataAdder.AddShipping(shipping);
				DataAdder.AddTransaction(new Transaction(id, o.TotalValue + fee, localDate, Transaction.GenerateID()));
			}

			for (int j = 0; j < random.nextInt(5); j++) {
				String orderId = Order.GenerateID();
				int amount = random.nextInt(5) + 1;
				Order o = OrderMaker(id, OrderStatus.FINISHED, amount, orderId);
				DataAdder.AddOrder(o);
				long fee = Shipping.generateFee(amount, mode);
				LocalDate localDate = LocalDate.of(2010 + random.nextInt(11), random.nextInt(12) + 1,
						random.nextInt(28) + 1);
				shipping = new Shipping(orderId, 1, fee, localDate, Shipping.GenerateID());
				DataAdder.AddShipping(shipping);
				DataAdder.AddTransaction(new Transaction(id, o.TotalValue + fee, localDate, Transaction.GenerateID()));
			}

			// DataAdder.AddOrder(OwnerID, Status, Products, Amounts, TotalValue, OrderID);
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

	static long total = 0;

	private static Order OrderMaker(String id, OrderStatus status, int productCount, String orderId) {
		Order o = new Order(id, orderId, status);

		int len = allProducts.size();

		for (int i = 0; i < productCount; i++) {
			Product p = allProducts.get(random.nextInt(len));
			int amount = 1 + random.nextInt(5);
			total += Product.getTotalValue(p, amount);
			o.addProduct(p, amount);
		}

		return o;
	}
}
