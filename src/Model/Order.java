package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DataController.CustomUUID;

public class Order {
	public String OwnerID, OrderID;
	public OrderStatus Status;
	public ArrayList<Product> Products;
	public ArrayList<Integer> Amounts;
	public long TotalValue;

	public Order(String ownerID, String orderID, OrderStatus status, ArrayList<Product> products,
			ArrayList<Integer> amounts) {
		super();
		OwnerID = ownerID;
		OrderID = orderID;
		Status = status;
		Products = products;
		Amounts = amounts;
		TotalValue = 0;

		CalculateTotalValue();
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
				//Amounts.get(i)=Amounts.get(i)+amount;
				Amounts.set(i, Amounts.get(i) + amount);
				return;
			}
		}

		Products.add(p);
		Amounts.add(amount);

		CalculateTotalValue();
	}

	public void PrintDetails() {
		System.out.println("====================================");
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
}
