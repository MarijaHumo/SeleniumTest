package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {
    WebDriver driver;
    WebElement loggedInNotification;
    WebElement logOutButton;
    WebElement welcomeMessage;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoggedInNotification() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
    }

    public WebElement getWelcomeMessage() {
        return driver.findElement(By.className("subheader"));
    }
    public void clickOnLogOutButton() {
        getLogOutButton().click();
    }
}
