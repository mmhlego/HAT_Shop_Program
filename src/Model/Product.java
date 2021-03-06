package Model;

import DataController.CustomUUID;

public class Product {
    public String Name, Description, Category, ID;
    public String[][] Details;
    public long Price;
    public int Percentage, Amount;

    public static final String PHONE = "Phone", ACCESSORIES = "Accessories", COMPUTER = "Computer", BOOK = "Book",
            SUPERMARKET = "SuperMarket";

    public Product() {
    };

    public Product(String name, String description, String[][] details, long price, int percentage, String category,
            int amount, String id) {
        Name = name;
        Description = description;
        Details = details;
        Price = price;
        Percentage = percentage;
        Category = category;
        Amount = amount;
        ID = id;
    }

    public static long getTotalValue(Product p, int amount) {
        return (p.Price * amount * (100 - p.Percentage)) / 100;
    }

    public long getTotalValue(int amount) {
        return (Price * amount * (100 - Percentage)) / 100;
    }

    public static String GenerateID() {
        // hat product - id
        return "HP-" + CustomUUID.Create(12);
    }

    public static String[][] ParseToArray(String s) {
        String[] all = s.split(",");
        int len = all.length;

        String[][] ans = new String[len / 2][2];

        for (int i = 0; i < len; i++) {
            ans[i / 2][i % 2] = format(all[i]);
        }

        return ans;
    }

    private static String format(String s) {
        s = s.replace("[", "").replace("]", "");
        if (s.indexOf(" ") == 0) {
            return s.substring(1, s.length());
        }
        return s;
    }

    public boolean equals(Product p) {
        if (this.ID.equals(p.ID)) {
            return true;
        }
        return false;
    }

    public boolean IsSpecial() {
        return (Percentage >= 20 || (Amount > 0 && Amount <= 15));
    }
}
