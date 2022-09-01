package hellocucumber;

import hellocucumber.webElement.LoginForm;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopMdAcoountLogin {

    WebDriver driver = new WebDriverCustom().getDriver();

    @Given("I am on home page")
    public void iAmOnHomePage(){
        driver.get("https://shop.md/en/");
    }

    @When("I insert incorrect data into login form")
    public void iInsertIncorrectDataIntoLoginForm() {
        driver.findElement(By.xpath("//*[@title='Log into your customer account']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-dark js-init-auth-recovery-modal']")).click();
        LoginForm form = new LoginForm(driver.findElement(By.xpath("//*[@id='js-auth-direct-form']")));
        form.getEmail().sendKeys("qweqwe");
        form.getPassword().sendKeys("123");
        form.getForm().submit();
    }

    @Then("must be {string} in login form")
    public void mustBeInLoginForm(String answer) {
        new WebDriverWait(driver, Duration.ofMillis(100L)).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return webDriver.findElements(By.xpath("//*[@class='alert alert-danger']")).isEmpty() ? "acepted" : "error";
            }
        });
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
