package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    WebElement usernameBox;
    WebElement passwordBox;
    WebElement loginButton;
    WebElement loggedOutNotification;
    WebElement usernameInvalidNottification;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameBox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordBox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public WebElement getLoggedOutNotification() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getUsernameInvalidNottification() {
        return driver.findElement(By.cssSelector(".flash.error"));
    }

    public void insertUsername(String username) {
        getUsernameBox().clear();
        getUsernameBox().sendKeys(username);
    }
    public void insertPassword(String password) {
        getPasswordBox().clear();
        getPasswordBox().sendKeys(password);
    }
    public void clickOnLogInButton() {
        getLoginButton().click();
    }
}
