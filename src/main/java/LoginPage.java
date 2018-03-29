import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fieldEmail = By.id("login_email");
    private By fieldPassword = By.id("login_password");
    private By buttonLogin = By.xpath("//button[@origtext='Login']");
    private By toolTip = By.xpath("//div[@id='login_frame']//div[@class='_logicstatus']");

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

    public String getTooltip() {
        return trim((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(toolTip)).getText());
    }
}
