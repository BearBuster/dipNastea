package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ShopMdAcoountLogin {

    WebDriver driver = new WebDriverCustom().getDriver();

    @Given("I am on home page")
    public void iAmOnHomePage(){
        driver.get("https://shop.md/en/");
    }

    @When("I insert incorrect data into login form")
    public void iInsertIncorrectDataIntoLoginForm() {
    }

    @Then("must be {string} in login form")
    public void mustBeInLoginForm(String arg0) {
    }

    @After
    public void closeDriver(){

    }
}
