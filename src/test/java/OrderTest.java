import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Table table = new Table(3);
    private Map<Product, Integer> products = new HashMap<>();
    private int sum = 0;

    private Product coffee = new Product(150, "Кофе");
    private Product cesar = new Product(300, "Цезарь");

    private Order order;


    @Given("^У заказа есть номер столика (\\d+)$")
    public void уЗаказаЕстьНомерСтолика(int arg0) {
        assertEquals(arg0, table.getNumber());
    }


    @Given("^В заказ можно добавлять продукт$")
    public void вЗаказМожноДобавлятьПродукт() {
        products.put(coffee, 2);
        products.put(cesar, 1);
    }

    @Given("^У заказа есть общая сумма заказа равная (\\d+) рублям$")
    public void уЗаказаЕстьОбщаяСуммаЗаказаРавнаяРублям(int arg0) {
        assertEquals(arg0, this.sum);
    }

    @When("^Мы создаем заказ с данным столиком и продуктами$")
    public void мыСоздаемЗаказСДаннымСтоликомИПродуктами() {
        this.order = new OrderTest(table);
    }

    @Then("^Мы можем узнать номер столика заказа равному (\\d+)$")
    public void мыМожемУзнатьНомерСтоликаЗаказаРавному(int arg0) {
        assertEquals(arg0, table.getNumber());
    }

    @And("^Мы можем узнать товары которые есть в этом заказе$")
    public void мыМожемУзнатьТоварыКоторыеЕстьВЭтомЗаказе() {
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            assertEquals(entry.getKey(), coffee);
            assertEquals(entry.getKey(), cesar);
        }
    }

    @And("^Мы можем узнать сумму заказа равную (\\d+) рублям$")
    public void мыМожемУзнатьСуммуЗаказаРавнуюРублям(int arg0) {
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            this.sum += entry.getKey().getPrice() * entry.getValue();
        }
    }
}
