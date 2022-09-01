package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopMdNavbar {

    WebDriver driver = new WebDriverCustom().getDriver();

    @Given("I am on any page of shop md")
    public void iAmOnAnyPageOfShopMd(){
        driver.get("https://shop.md/en/");
    }

    @When("I hover on element")
    public void iHoverOnElement() {
        Actions actions = new Actions(driver);
        WebElement navOption = driver.findElement(By.xpath("//*[@id=\"accordionHeader\"]/div[1]/div[1]/a[text()='Food']"));
        actions.moveToElement(navOption).perform();
    }

    @Then("dropdown must be {string}")
    public void dropdownMustBe(String expected_result) throws InterruptedException {
        String actual_result = (String) new WebDriverWait(driver, Duration.ofMillis(100L)).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath("//*[@id=\"collapsecategory-22\"]/div/div/div/div[1]")).isDisplayed() ? "displayed" : "hidden";
            }
        });
        assertEquals(expected_result, actual_result);
    }

    @After()
    public void closeWebDriver(){
        driver.quit();
    }
}
