import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {

    private WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    private By okButton = By.id("exitget_input_2");

    public void clickOkButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(okButton)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(okButton));
    }

    public boolean isVisible(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(okButton)).isDisplayed();
    }
}
