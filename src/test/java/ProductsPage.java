import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;
    @FindBy(xpath = "(//a[contains(text(),'View Product')])[5]") private WebElement firstProductBtn;
    @FindBy(xpath = "//div[@class='product-information']")private WebElement productPhoto;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickAddToCart(){
        firstProductBtn.click();
    }
    public boolean isProductPageVisible(){
        return (productPhoto.isDisplayed());
    }

}
