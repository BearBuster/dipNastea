package hellocucumber.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountCreationForm {
    WebElement first_name;
    WebElement last_name;
    WebElement email;
    WebElement password;
    WebElement phone;
    WebElement submitButton;
    WebElement form;

    public WebElement getFirst_name() {
        return first_name;
    }

    public WebElement getLast_name() {
        return last_name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getForm() {
        return form;
    }

    public AccountCreationForm(WebElement formElement){
        this.first_name = formElement.findElement(By.xpath("//input[@name=\"firstname\"]"));
        this.last_name = formElement.findElement(By.xpath("//input[@name=\"lastname\"]"));
        this.email = formElement.findElement(By.xpath("//input[@name=\"email\"]"));
        this.password = formElement.findElement(By.xpath("//input[@name=\"password\"]"));
        this.phone = formElement.findElement(By.xpath("//input[@name=\"phone\"]"));
        this.submitButton = formElement.findElement(By.xpath("//input[@name=\"lastname\"]"));
        this.form = formElement.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[7]/button"));
    }

}
