import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class LoginPage {
    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fieldEmail = By.id("userInput");
    private By fieldPassword = By.id("passwordInput");
    private By buttonLogin = By.id("sendInput");
    private By header = By.xpath("//div[@id='login_frame']//div[@class='contentlabel font_size_by_height']");
    private static String url = "https://exitget.com";
    private By linkNeedHelp = By.xpath("//a[text()='Need help?']");
    private By linkForgotPassword = By.xpath("//a[@href='//exitget.com/login/forgot']");
    private By linkCreateNewOne = By.xpath("//a[@href='//exitget.com/pricing']");


    public String getHeader(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return trim(driver.findElement(header).getText());
    }

    private LoginPage inputEmail(String email){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    private LoginPage inputPassword(String passwd){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(fieldPassword).sendKeys(passwd);
        return this;
    }

    public void login(String email, String passwd){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputEmail(email);
        inputPassword(passwd);
        driver.findElement(buttonLogin).submit();
    }

    public void loginWithCorrectData(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        openLoginPage();
        login("exitgetest@gmail.com", "Ckfdfnhele_1");
        wait.until(ExpectedConditions.titleIs("Dashboard - Exitget"));
        Assertions.assertEquals("Dashboard - Exitget", driver.getTitle(),
                "Login with correct data - We are not on the Overview page");
    }

    public void checkNeedHelpLink(){
        openLoginPage();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(linkNeedHelp));
        String attrLink = driver.findElement(linkNeedHelp).getAttribute("href");
        Assertions.assertEquals("mailto:support@exitget.com", attrLink, "Need Help link isn't refered to mailto:support@exitget.com");
    }

    public void checkForgotPasswordLink(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        openLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkForgotPassword)).click();
        wait.until(ExpectedConditions.titleIs("Forgot password - Exitget"));
        Assertions.assertEquals("Forgot password - Exitget", driver.getTitle(), "Check Forgot password link - We are not on the Account Recovery page" );
    }

    public void checkCreateNewOneLink(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        openLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkCreateNewOne)).click();
        wait.until(ExpectedConditions.titleIs("Pricing - Exitget"));
        Assertions.assertEquals("Pricing - Exitget", driver.getTitle(), "Check Create a New One link - We are not on the Price page" );
    }
    private void openLoginPage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        driver.get(url);
        mainPage.clickHeaderLoginButton();
    }
}
