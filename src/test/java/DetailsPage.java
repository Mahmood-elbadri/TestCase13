import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {
    @FindBy(xpath = "//input[@id='quantity']")private WebElement quantity;
    @FindBy(xpath = "//button[@type='button']")private WebElement addBtn;
    @FindBy(xpath = "(//u[normalize-space()='View Cart'])[1]")private WebElement viewCart;
    @FindBy(xpath = "//button[@class='disabled']")private WebElement actualQuantity;
    ////button[normalize-space()='2']
    WebDriver driver;

    public DetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void saveNewQuantity(){
        quantity.clear();
        quantity.sendKeys("4");
        addBtn.click();
        viewCart.click();
    }
    public boolean currentQuantity(){
        String quantity =  (actualQuantity.getText());
        int number = Integer.parseInt(quantity);
        return (number == 4)?true:false;
    }
}
