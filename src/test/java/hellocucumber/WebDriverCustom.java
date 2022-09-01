package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCustom {

    private final WebDriver driver;

    WebDriverCustom(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        this.driver = new FirefoxDriver();
    };

    public WebDriver getDriver(){
        return driver;
    }


//    private final WebDriver driver = new FirefoxDriver();
}

