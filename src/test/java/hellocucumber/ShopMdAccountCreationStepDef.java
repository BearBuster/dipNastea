package hellocucumber;

import hellocucumber.webElement.AccountCreationForm;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopMdAccountCreationStepDef {

    private WebDriver driver = new WebDriverCustom().getDriver();

    @Given("I am on account creation form")
    public void iAmOnAccountCreationForm() {
        driver.get("https://shop.md/en/login?create_account=1");
    }

    @When("I insert incorrect data")
    public void iInsertIncorrectData() throws InterruptedException {
        AccountCreationForm form = new AccountCreationForm(driver.findElement(By.xpath("//*[@id=\"customer-form\"]")));
        form.getLast_name().sendKeys("Jeka");
        form.getFirst_name().sendKeys("qwe");
        form.getEmail().sendKeys("qweqweqw");
        Thread.sleep(100);
    }

    @Then("must be error {string}")
    public void mustBeError(String err) {
        String s = driver.findElements(By.xpath("//*[class='alert alert-danger'")).isEmpty() ? "No err" : "Error";
    }

    @After()
    public void closeWebDriver(){
        driver.quit();
    }
}
