package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class shopMdStepDef {

    private WebDriver driver = new WebDriverCustom().getDriver();

    @Given("I am on the shop md web site on home page")
    public void iAmOnTheShopMdWebSiteOnHomePage() {
        driver.get("https://shop.md/en/");
    }

    @When("I select {string} option in navbar")
    public void iSelectOptionInNavbar(String option) {
        driver.findElement(By.xpath("//*[@id='accordionHeader']/div/div[1]/a[contains(text(),'"+ option +"')]")).click();
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String title) {
        new WebDriverWait(driver, Duration.ofMillis(100L)).until(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver webDriver) {
                System.out.println(webDriver.getTitle());
                return webDriver.getTitle().startsWith(title);
            }
        });
    }

    @After()
    public void closeWebDriver(){
        driver.quit();
    }

}
