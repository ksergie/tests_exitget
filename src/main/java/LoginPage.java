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
    private By header = By.xpath("//div[@id='login_frame']//div[@class='contentlabel font_size_by_height']");

    public String getHeader(){
        return trim((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(header)).getText());
    }

    private LoginPage inputEmail(String email){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(fieldEmail)).sendKeys(email);
        return this;
    }

    private LoginPage inputPassword(String passwd){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(fieldPassword)).sendKeys(passwd);
        return this;
    }

    public void login(String email, String passwd){
        inputEmail(email);
        inputPassword(passwd);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(buttonLogin)).submit();
    }

    public String getTooltip() {
        return trim((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(toolTip)).getText());
    }
}
