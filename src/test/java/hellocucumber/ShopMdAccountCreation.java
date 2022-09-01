package hellocucumber;

import hellocucumber.webElement.AccountCreationForm;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopMdAccountCreation {

    WebDriver driver = new WebDriverCustom().getDriver();

    @Given("qweqwe")
    public void qwe(){}
//    @Given("I am on account creation form")
//    public void iAmOnAccountCreationForm(){
//        driver.get("https://shop.md/en/login?create_account=1");
//    }
//
//    @When("I insert incorrect data")
//    public void iInsertIncorrectData() {
//        AccountCreationForm form = new AccountCreationForm(driver.findElement(By.xpath("//*[@id=\"customer-form\"]")));
//        form.getLast_name().sendKeys("Jeka");
//        form.getFirst_name().sendKeys("qwe");
//        form.getEmail().sendKeys("qweqweqw");
//    }
//
//    @Then("must be error {string}")
//    public void mustBeError(String arg0) {
//        new WebDriverWait(driver, Duration.ofMillis(10L)).until(new ExpectedCondition<Object>() {
//            @Override
//            public Object apply(WebDriver webDriver) {
//                return webDriver.findElements(By.xpath("//*[class='alert alert-danger'")).isEmpty() ? "No err" : "Error";
//            }
//        });
//    }

    @Given("I am on account creation form")
    public void iAmOnAccountCreationForm() {
        driver.get("https://shop.md/en/login?create_account=1");
    }

    @When("I insert incorrect data")
    public void iInsertIncorrectData() throws InterruptedException {
        AccountCreationForm form = (AccountCreationForm) new WebDriverWait(driver, Duration.ofMillis(10L)).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return new AccountCreationForm(driver.findElement(By.xpath("//*[@id=\"customer-form\"]")));
            }
        });
        form.getLast_name().sendKeys("Jeka");
        form.getFirst_name().sendKeys("qwe");
        form.getEmail().sendKeys("qweqweqw");
        form.getPassword().sendKeys("123123");
        form.getPhone().sendKeys("12414124");
    }

    @Then("must be error {string}")
    public void mustBeError(String answer) {
        String actual_result = (String) new WebDriverWait(driver, Duration.ofMillis(100L)).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return webDriver.findElements(By.xpath("//*[@class='alert alert-danger']")).isEmpty() ? "acepted" : "Error";
            }
        });

        assertEquals(answer,actual_result);
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
