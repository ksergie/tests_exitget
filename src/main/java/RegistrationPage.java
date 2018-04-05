import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerNameField = By.id("registername");
    private By registereMailField = By.id("registeremail");
    private By registerPasswdField = By.id("registerpass");
    private By legalCheckbox = By.id("legalCheckbox");
    private By registerButton = By.xpath("//button[@origtext='Register']");

    private RegistrationPage inputName(String userName){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(registerNameField)).sendKeys(userName);
        return this;
    }

    private RegistrationPage inputEMail(String email){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(registereMailField)).sendKeys(email);
        return this;
    }

    private RegistrationPage inputPassword(String passwd){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(registerPasswdField)).sendKeys(passwd);
        return this;
    }

    private RegistrationPage tickCheckBox() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(legalCheckbox)).click();
        return this;
    }

    private RegistrationPage clickRegisterButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
        return this;
    }

    public void register(String username, String email, String passwd){
        inputName(username);
        inputEMail(email);
        inputPassword(passwd);
        tickCheckBox();
        clickRegisterButton();
    }
}
