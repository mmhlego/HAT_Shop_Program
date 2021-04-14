package Model;

public class Product {
    
    private String Name, Description, Details, Category, ID;
    private long Price;
    private int Percentage, Amount;

    public Product(String name, String description, String details, long price, int percentage, String category,
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
}
