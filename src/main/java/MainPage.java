import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerLoginButton = By.id("headerLogin");
    private By topImageRegisterButton = By.id("topImageRegister");

    public void clickHeaderLoginButton() {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(headerLoginButton)).click();
    }
    public void clickTopImageRegisterButton(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(topImageRegisterButton)).click();
    }
}
