package hellocucumber.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginForm {

    WebElement email;
    WebElement password;
    WebElement form;

    public LoginForm(WebElement form){
        this.form = form;
        this.email = form.findElement(By.xpath("//input[@name='email']"));
        this.password = form.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getForm() {
        return form;
    }
}
