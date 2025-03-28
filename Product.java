import java.util.HashMap;

public class Product {
    private String SKU, name, description;
    private HashMap<String, Integer> amount_size;

    public Product(String SKU, String name, String description, HashMap<String, Integer> amount_size){
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.amount_size = amount_size;
    }
}
