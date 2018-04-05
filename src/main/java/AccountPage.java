import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerPage = By.xpath("(//div[@class='inputlabel']/b)[1]");
    private By resetAccountButton = By.xpath("//button[@action='reset']");
    private By inputCurrentPasswordField = By.id("accountpass2");
    private By accountResultMessage = By.id("accountResultMessage");
    private By closeButton = By.xpath("//button[@action='close']");


    public String getHeaderPage(){
        return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(headerPage)).getText();
    }

    public AccountPage inputCurrentPassword(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(inputCurrentPasswordField)).sendKeys("20exitget17");
        return this;
    }

    public AccountPage clickResetAccountButton(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(resetAccountButton)).click();
        return this;
    }

    public AccountPage closeAlertWindow() {
        driver.switchTo().alert().accept();
        return this;
    }

    public String getAccountResultMessage(){
        return (new WebDriverWait(driver, 20)).until(ExpectedConditions.textToBe(accountResultMessage, "Reset complete")).toString();
    }

    public void clickCloseButton(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();
    }
}
