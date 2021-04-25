package DataController;

import java.sql.*;
import java.util.*;
import Model.*;

public class ProductChecker {

    public static ArrayList<Product> LoadAllProducts() {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("Select * From `Products`");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToProductsArrayList(r);
    }

    public static ArrayList<Product> LoadCategoryProducts(String Category) {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("Select * From Products WHERE Category=" + "\'" + Category + "\'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToProductsArrayList(r);
    }

    private static ArrayList<Product> ConvertToProductsArrayList(ResultSet r) {
        ArrayList<Product> temp = new ArrayList<Product>();

        try {
            while (r.next()) {
                Product P = new Product(r.getString(1), r.getString(2), Product.ParseToArray(r.getString(3)),
                        r.getLong(4), r.getInt(5), r.getString(6), r.getInt(7), r.getString(8));

                temp.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public static Product GetProduct(String ID) {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("SELECT * FROM `Products` WHERE ID =\'" + ID + "\'");

            return ConvertToProduct(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Product ConvertToProduct(ResultSet r) {
        try {
            if (r.next()) {
                return new Product(r.getString(1), r.getString(2), Product.ParseToArray(r.getString(3)), r.getLong(4),
                        r.getInt(5), r.getString(6), r.getInt(7), r.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> GetCategoriesName() {
        ResultSet r = null;
        try {
            r = DBConnector.RunCommand("SELECT DISTINCT Category FROM Products");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConvertToStringArrayList(r);
    }

    private static ArrayList<String> ConvertToStringArrayList(ResultSet r) {
        ArrayList<String> temp = new ArrayList<String>();
        try {
            while (r.next()) {
                temp.add(r.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
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

    public static boolean SpecialProduct(String ID) {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT Percentage , Amount FROM Products WHERE ID =" + "\'" + ID + "\'");
            r.next();
            int Percentage = r.getInt(1);
            int Amount = r.getInt(2);
            if (Percentage >= 20 || Amount <= 15) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean ProductLowAmount(String ID) {
        if (GetProductAmount(ID) <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Product> GetSpecialProducts() {
        try {
            ResultSet r = DBConnector
                    .RunCommand("SELECT * FROM Products WHERE (Percentage >=20 OR Amount <=15) AND Amount>0");
            return ConvertToProductsArrayList(r);
        } catch (Exception e) {
            System.out.println("No Special Products Found (Product Checker)");
        }
        return new ArrayList<Product>();
    }

    public static long GetMaxValue() {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT MAX(Price)FROM Products");
            r.next();
            return r.getLong(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long GetMinValue() {
        try {
            ResultSet r = DBConnector.RunCommand("SELECT MIN(Price)FROM Products");
            r.next();
            return r.getLong(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
