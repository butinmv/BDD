import com.sun.tools.javac.util.Name;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class TableTest {

    private int number;

    private Name.Table table;


    @Given("^У стола есть номер (\\d+)$")
    public void уСтолаЕстьНомер(int arg0) {
        this.number = arg0;
    }

    @When("^Мы создаем стол с данным номером$")
    public void мыСоздаемСтолСДаннымНомером() {
        this.table = new Name.Table(number);
    }


    @Then("^Мы можем узнать номер стола равной (\\d+)$")
    public void мыМожемУзнатьНомерСтолаРавной(int arg0) {
        assertEquals(arg0, this.table.getNumber());
    }
}
