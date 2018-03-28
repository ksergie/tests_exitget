import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fieldEmail = By.id("login_email");
    private By fieldPassword = By.id("login_password");
    private By buttonLogin = By.xpath("//button[@origtext='Login']");

    private LoginPage inputEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    private LoginPage inputPassword(String passwd){
        driver.findElement(fieldPassword).sendKeys(passwd);
        return this;
    }

    public void login(String email, String passwd){
        inputEmail(email);
        inputPassword(passwd);
        driver.findElement(buttonLogin).submit();
    }
}
