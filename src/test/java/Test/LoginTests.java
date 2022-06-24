package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    String validUsername = "tomsmith";
    String validPassword = "SuperSecretPassword!";
    String invalidUsername = "domsmith";
    String invalidPassword = "DuperSecretPassword!";

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://the-internet.herokuapp.com/login\n");
        driver.manage().window().maximize();
    }

    public void goldenPath() {
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnLogInButton();
    }

    @Test
    public void successfulLogin() {

        goldenPath();

        Assert.assertEquals(secureAreaPage.getWelcomeMessage().getText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(secureAreaPage.getLoggedInNotification().isDisplayed());
        Assert.assertEquals(secureAreaPage.getLoggedInNotification().getText(), "You logged into a secure area!\n" +
                "×");


        boolean check = false;
            try {
        check = loginPage.getLoginButton().isDisplayed();
    } catch (Exception e) {

    }

            Assert.assertFalse(check);
}

@Test
    public void succesfulLogout() {
    goldenPath();
    secureAreaPage.clickOnLogOutButton();
    Assert.assertTrue(loginPage.getLoggedOutNotification().isDisplayed());
    Assert.assertEquals(loginPage.getLoggedOutNotification().getText(), "You logged out of the secure area!\n" +
            "×");
}
@Test
    public void unsuccessfulLoginInvalidUsername() {
    loginPage.insertUsername(invalidUsername);
    loginPage.insertPassword(validPassword);
    loginPage.clickOnLogInButton();

    Assert.assertTrue(loginPage.getUsernameInvalidNottification().isDisplayed());
    Assert.assertEquals(loginPage.getUsernameInvalidNottification().getText(), "Your username is invalid!\n" +
            "×");
}

@Test
    public void unsuccessfullLoginInvalidPassword() {
    loginPage.insertUsername(validUsername);
    loginPage.insertPassword(invalidPassword);
    loginPage.clickOnLogInButton();


    // nisam stigla assert


}
}

