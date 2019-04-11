import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private int price;
    private String name;

    private Product product;

    @Given("^У продукта есть цена (\\d+) рублей$")
    public void уПродуктаЕстьЦенаРублей(int arg0) {
        this.price = arg0;
    }

    @Given("^У продукта есть название \"([^\"]*)\"$")
    public void уПродуктаЕстьНазвание(String arg0) {
        this.name = arg0;
    }

    @When("^Мы создаем продукт с данной ценной и названием$")
    public void мыСоздаемПродуктСДаннойЦеннойИНазванием() {
        this.product = new Product(price, name);
    }

    @Then("^Мы можем узнать цену продукта равной (\\d+) рублей$")
    public void мыМожемУзнатьЦенуПродуктаРавнойРублей(int arg0) {
        assertEquals(arg0, product.getPrice());
    }

    @And("^Мы можем узнать название продукта равным \"([^\"]*)\"$")
    public void мыМожемУзнатьНазваниеПродуктаРавным(String arg0) {
        assertEquals(arg0, product.getName());
    }
}
