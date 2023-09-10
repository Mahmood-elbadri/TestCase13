import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestCases {
    WebDriver driver;
    HomePage home;
    ProductsPage product;
    DetailsPage detail;
    SoftAssert soft;
    String url = "";

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new HomePage(driver);
        product = new ProductsPage(driver);
        soft = new SoftAssert();
        detail = new DetailsPage(driver);
        url = "https://automationexercise.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test(priority = 0, enabled = true)
    public void verifyHome() {
        boolean isDisplayed = home.isHomePageVisible();
        Assert.assertTrue(isDisplayed);
        home.clickProductsBtn();
    }
    @Test(priority = 1,enabled = true)
    public void firstProduct() {
        product.clickAddToCart();
    }
    @Test(priority = 2,enabled = true)
    public void isProductPageDisplayed(){
        boolean isDisplayed = (product.isProductPageVisible());
        soft.assertTrue(isDisplayed);
    }
    @Test(priority = 3,enabled = true)
    public void editDressQuantity(){
        detail.saveNewQuantity();
    }
    @Test(priority = 4,enabled = true)
    public void boughtQuantity(){
        soft.assertTrue(detail.currentQuantity());
        soft.assertAll();
    }

}
