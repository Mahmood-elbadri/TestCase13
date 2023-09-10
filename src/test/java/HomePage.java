import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement homeLogo;
    @FindBy(xpath = "//a[@href='/products']")WebElement productsBtn;
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isHomePageVisible(){
        return (homeLogo.isDisplayed());
    }
    public void clickProductsBtn(){
        productsBtn.click();
    }
}
