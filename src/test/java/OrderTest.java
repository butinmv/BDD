import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Table table;
    private Map<Product, Integer> products = new HashMap<>();

    private Product coffee = new Product(150, "Кофе");
    private Product cesar = new Product(300, "Цезарь");

    private Order order;


    @Given("^У заказа есть номер столика (\\d+)$")
    public void уЗаказаЕстьНомерСтолика(int arg0) {
        this.table = new Table(3);
        assertEquals(arg0, table.getNumber());
    }

    @When("^Мы создаем заказ с данным столиком$")
    public void мыСоздаемЗаказСДаннымСтоликом() {
        this.order = new Order(table);
    }

    @Then("^В заказ можно добавить продукт кофе$")
    public void вЗаказМожноДобавитьПродуктКофе() {
        order.addProduct(coffee, 2);
    }

    @And("^В заказ можно добавить продукт цезарь$")
    public void вЗаказМожноДобавитьПродуктЦезарь() {
        order.addProduct(cesar, 1);
    }

    @And("^У заказа есть общая сумма заказа равная (\\d+) рублям$")
    public void уЗаказаЕстьОбщаяСуммаЗаказаРавнаяРублям(int arg0) {
        assertEquals(arg0, order.sumTotal());
    }

    @And("^Мы можем узнать номер столика заказа равному (\\d+)$")
    public void мыМожемУзнатьНомерСтоликаЗаказаРавному(int arg0) {
        assertEquals(arg0, table.getNumber());
    }


    @And("^Мы можем узнать сумму заказа равную (\\d+) рублям$")
    public void мыМожемУзнатьСуммуЗаказаРавнуюРублям(int arg0) {
        assertEquals(arg0, order.sumTotal());
    }

    @And("^Мы можем узнать количесвто (\\d+) продуктов которые есть в этом заказе$")
    public void мыМожемУзнатьКоличесвтоПродуктовКоторыеЕстьВЭтомЗаказе(int arg0) {
        assertEquals(arg0, order.getProducts().size());
    }
}
