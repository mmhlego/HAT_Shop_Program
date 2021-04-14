package DataController;

import java.sql.*;
import java.util.*;
import Model.*;

public class ProductChecker {

    public static ArrayList<Product> LoadALlProducts() {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("Select * From Products");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToArrayList(r);
    }

    public static Product GetProduct(String ID) {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("SELECT * FROM Products WHERE ID =" + "\'" + ID + "\'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToProduct(r);
    }

    public static ArrayList<Product> LoadCategoryProducts(String Category) {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("Select * From Products WHERE Category=" + "\'" + Category + "\'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToArrayList(r);
    }

    public static int GetProductAmount(String ID) {
        int Count = 0;
        try {
            ResultSet r = DBConnector.RunCommand("SELECT Amount FROM Products WHERE ID=" + "\'" + ID + "\'");
            r.next();
            Count = r.getInt(1);
            return Count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static ArrayList<Product> ConvertToArrayList(ResultSet r) {
        ArrayList<Product> temp = new ArrayList<Product>();
        try {
            while (r.next()) {
                Product P = new Product(r.getString(1), r.getString(2), r.getString(3), r.getLong(4), r.getInt(5),
                        r.getString(6), r.getInt(7), r.getString(8));

                temp.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    private static Product ConvertToProduct(ResultSet r) {
        try {
            r.next();
            return new Product(r.getString(1), r.getString(2), r.getString(3), r.getLong(4), r.getInt(5),
                    r.getString(6), r.getInt(7), r.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
