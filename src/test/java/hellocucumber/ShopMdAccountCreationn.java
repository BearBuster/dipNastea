package hellocucumber;

import hellocucumber.webElement.AccountCreationForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopMdAccountCreationn {

    WebDriver driver = new WebDriverCustom().getDriver();
    @Given("I am on account creation formm")
    public void iAmOnAccountCreationFormm(){
        driver.get("https://shop.md/en/login?create_account=1");
    }

    @When("I insert incorrect dataa")
    public void iInsertIncorrectDataa() {
        AccountCreationForm form = new AccountCreationForm(driver.findElement(By.xpath("//*[@id=\"customer-form\"]")));
        form.getLast_name().sendKeys("Jeka");
        form.getFirst_name().sendKeys("qwe");
        form.getEmail().sendKeys("qweqweqw");
    }

    @Then("must be errorr {string}")
    public void mustBeErrorr(String arg0) {
        String s = driver.findElements(By.xpath("//*[class='alert alert-danger'")).isEmpty() ? "No err" : "Error";
    }
}
