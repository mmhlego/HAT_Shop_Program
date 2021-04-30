package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DataController.CustomUUID;
import DataController.ProductChecker;

public class Order {
	public String OwnerID, OrderID;
	public OrderStatus Status;
	public ArrayList<Product> Products;
	public ArrayList<Integer> Amounts;
	public long TotalValue;

	public Order(String ownerID, OrderStatus status, ArrayList<Product> products, ArrayList<Integer> amounts,
			String orderID) {
		this(ownerID, status, products, amounts, 0, orderID);

		CalculateTotalValue();
	}

	public Order(String ownerID, OrderStatus status, ArrayList<Product> products, ArrayList<Integer> amounts,
			long value, String orderID) {
		OwnerID = ownerID;
		OrderID = orderID;
		Status = status;
		Products = products;
		Amounts = amounts;
		TotalValue = value;
	}

	public static ArrayList<Product> GetIDsProducts(String productIDs) {
		ArrayList<Product> temp = new ArrayList<Product>();
		if (productIDs.equals("[]")) {
			return temp;
		}
		String[] IDs = productIDs.replace("[", "").replace("]", "").replace(" ", "").split(",");
		for (String id : IDs) {
			temp.add(ProductChecker.GetProduct(id));
		}
		return temp;
	}

	public static ArrayList<Integer> GetIDsAmounts(String amounts) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (amounts.equals("[]")) {
			return temp;
		}
		for (String Amount : amounts.replace("[", "").replace("]", "").replace(" ", "").split(",")) {
			temp.add(Integer.parseInt(Amount));
		}
		return temp;
	}

	public ArrayList<String> GetProductIDs() {
		ArrayList<String> ids = new ArrayList<String>();

		for (Product p : Products) {
			ids.add(p.ID);
		}

		return ids;
	}

	public Order(String ownerID, String orderID, OrderStatus status) {
		super();
		OwnerID = ownerID;
		OrderID = orderID;
		Status = status;
		Products = new ArrayList<Product>();
		Amounts = new ArrayList<Integer>();
		TotalValue = 0;
	}

	private void CalculateTotalValue() {
		long total = 0;

		for (int i = 0; i < Products.size(); i++) {
			total += Products.get(i).getTotalValue(Amounts.get(i));
		}

		TotalValue = total;
	}

	public void addProduct(Product p, int amount) {
		for (int i = 0; i < Products.size(); i++) {
			if (Products.get(i).equals(p)) {
				// Amounts.get(i)=Amounts.get(i)+amount;
				Amounts.set(i, Amounts.get(i) + amount);
				return;
			}
		}

		Products.add(p);
		Amounts.add(amount);

		CalculateTotalValue();
	}

	public int contains(String ProductID) {
		int counter = 0;
		for (Product p : Products) {
			if (p.ID.equals(ProductID)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	public void PrintDetails() {
		System.out.println("==================Order================");
		System.out.println("owner: " + OwnerID);
		System.out.println("Status: " + OrderStatus.ModeToInt(Status));
		System.out.println("" + GetProductIDs());
		System.out.println("" + Amounts);
		System.out.println("" + TotalValue);
		System.out.println("" + OrderID);
	}

	public static String GenerateID() {
		LocalDateTime dt = LocalDateTime.now();
		String date = dt.format(DateTimeFormatter.ofPattern("YYMMddHHmm"));
		String id = CustomUUID.Create(4);

		return "HO-" + date + id;
	}

	public enum OrderStatus {
		PENDING, SENDING, FINISHED;

		public static int ModeToInt(OrderStatus u) {
			switch (u) {
				case PENDING:
					return 0;
				case SENDING:
					return 1;
				case FINISHED:
					return 2;
			}
			return -1;
		}

		public static OrderStatus IntToMode(int u) {
			switch (u) {
				case 0:
					return OrderStatus.PENDING;
				case 1:
					return OrderStatus.SENDING;
				case 2:
					return OrderStatus.FINISHED;
			}
			return null;
		}
	}

	public void BuyProducts() {
		for (int i = 0; i < Products.size(); i++) {
			ProductChecker.AddProductAmount(Products.get(i).ID, -Amounts.get(i));
		}
	}
}
