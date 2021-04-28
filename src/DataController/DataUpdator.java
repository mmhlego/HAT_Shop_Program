package DataController;

import java.util.ArrayList;
import java.util.Arrays;

import Model.Order;

public class DataUpdator {
	public static void UpdateOrder(Order o) {
		try {
			UpdateOrder(o.GetProductIDs(), o.Amounts, o.TotalValue, o.OrderID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpdateOrder(ArrayList<String> ProductIDs, ArrayList<Integer> Amounts, long TotalValue,
			String OrderID) {
		try {
			DBConnector.Con.prepareStatement("UPDATE `Orders` SET `Products`=\'" + Arrays.toString(ProductIDs.toArray())
					+ "\',`Amounts`=\'" + Arrays.toString(Amounts.toArray()) + "\',`TotalValue`=\'" + TotalValue
					+ "\' WHERE `OrderID` = \'" + OrderID + "\'").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpdateOrderStatus(Order o) {
		try {
			DBConnector.Con.prepareStatement("UPDATE `Orders` SET `Status`=" + Order.OrderStatus.ModeToInt(o.Status)
					+ " WHERE `OrderID` = \'" + o.OrderID + "\'").executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
