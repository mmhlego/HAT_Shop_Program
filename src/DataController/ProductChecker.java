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

    public static ArrayList<Product> LoadCategoryProducts(String Category) {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("Select * From Products WHERE Category=" + "\'" + Category + "\'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToArrayList(r);
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

}
