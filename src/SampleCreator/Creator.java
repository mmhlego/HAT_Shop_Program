package SampleCreator;

import DataController.DBConnector;

public class Creator {
    public static void CreateSamples(boolean employee, boolean customers, boolean products) {
        if (DBConnector.Connect()) {
            System.out.println("Starting Datacreator");
        } else {
            System.out.println("Disconnected. Trying again . . .");
            CreateSamples(employee, customers, products);
            return;
        }

        if (products) {
            DeleteAllProducts();
            ProductCreator.Create();
            System.out.println("Added new products");
        }

        if (customers) {
            DeleteAllCustomerData();
            CustomerCreator.CustomerAdder(150);
            System.out.println("Added new customers");
        }

        if (employee) {
            DeleteAllEmployeeData();
            EmployeeCreator.Create();
            System.out.println("Added new employees");
        }
    }

    private static void DeleteAllProducts() {
        try {
            DBConnector.Con.prepareStatement("DELETE FROM `Products` WHERE 1").executeUpdate();
        } catch (Exception e) {
        }
        System.out.println("Deleted All Products");
    }

    private static void DeleteAllCustomerData() {
        try {
            DBConnector.Con.prepareStatement("DELETE FROM `Customers` WHERE 1").executeUpdate();
            DBConnector.Con.prepareStatement("DELETE FROM `Orders` WHERE 1").executeUpdate();
            DBConnector.Con.prepareStatement("DELETE FROM `Shipping` WHERE 1").executeUpdate();
            DBConnector.Con.prepareStatement("DELETE FROM `Transactions` WHERE 1").executeUpdate();
        } catch (Exception e) {
        }
        System.out.println("Deleted All Customers");
    }

    private static void DeleteAllEmployeeData() {
        try {
            DBConnector.Con.prepareStatement("DELETE FROM `Employees` WHERE 1").executeUpdate();
        } catch (Exception e) {
        }
        System.out.println("Deleted All Employees");
    }
}
