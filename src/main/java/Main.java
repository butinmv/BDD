public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        Product coffee = new Product(150, "Кофе");
        Product cesar = new Product(300, "Цезарь");

        Order order = new Order(table);
        order.addProduct(coffee, 2);
        order.addProduct(cesar, 1);

        int sum = order.sumTotal();
        System.out.println(sum);

    }
}
