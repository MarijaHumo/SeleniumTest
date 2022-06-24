package Base;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public SecureAreaPage secureAreaPage;
    public ExcelReader excelReader;

@BeforeClass
public void setUp() throws IOException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    loginPage = new LoginPage(driver);
    secureAreaPage = new SecureAreaPage(driver);
    excelReader = new ExcelReader("C:\\Users\\User\\Desktop\\SeleniumTest.xlsx");
    }

@AfterClass
public void tearDown() {
    driver.close();
    driver.quit();
}
}

