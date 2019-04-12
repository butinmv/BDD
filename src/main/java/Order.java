import java.util.HashMap;
import java.util.Map;

public class Order {

    private Table table;
    private Map<Product, Integer> products = new HashMap<>();
    private int sum = 0;

    public Order(Table table) {
        this.table = table;
    }

    public int sumTotal() {
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            this.sum += entry.getKey().getPrice() * entry.getValue();
        }
        return this.sum;
    }

    public Table getTable() {
        return table;
    }

    public void addProduct(Product product, int count) {
        products.put(product, count);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
