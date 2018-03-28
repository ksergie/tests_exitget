import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerLoginButton = By.id("headerLogin");

    public void clickHeaderLoginButton() {
        driver.findElement(headerLoginButton).click();
    }
}
