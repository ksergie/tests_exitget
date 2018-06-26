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

    private By fieldEmail = By.id("login_email");
    private By fieldPassword = By.id("login_password");
    private By buttonLogin = By.xpath("//button[@origtext='Login']");
    private By toolTip = By.xpath("//div[@id='login_frame']//div[@class='_logicstatus']");
    private By header = By.xpath("//div[@id='login_frame']//div[@class='contentlabel font_size_by_height']");
    private static String url = "https://exitget.com";

    // 0 - login, 1 - password, 2 - expected string, 3 - error message
    private String[][] data = {
            {"", "", "You must provide the email address you registered with.", "Login without data - Tooltip is not correspond the user's input"},
            {"exitgetest@gmail.com", "", "You must provide a password to login.", "Login without password - Tooltip is not correspond the user's input"},
            {"123qwer", "Ckfdfnhele_1", "You must provide a valid email address.", "Login with incorrect email - Tooltip is not correspond the user's input"},
            {"exitgetest@gmail.com", "20exitget20", "The login information you provided was not correct.", "Login with incorrect password - Tooltip is not correspond the user's input"},
            {"exitgetest999999@gmail.com", "Ckfdfnhele_1", "The login information you provided was not correct.", "Login with unregistered email - Tooltip is not correspond the user's input"}
    };

    public String getHeader(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return trim((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(header)).getText());
        return trim(driver.findElement(header).getText());
    }

    private LoginPage inputEmail(String email){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(fieldEmail)).sendKeys(email);
        driver.findElement(fieldEmail).sendKeys(email);
        return this;
    }

    private LoginPage inputPassword(String passwd){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(fieldPassword).sendKeys(passwd);
        return this;
    }

    public void login(String email, String passwd){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputEmail(email);
        inputPassword(passwd);
//        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(buttonLogin)).submit();
        driver.findElement(buttonLogin).submit();
    }

    public String getTooltip() {
        return trim((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(toolTip)).getText());
    }

    public void loginWithIncorrectData(){
        MainPage mainPage = new MainPage(driver);

        for(int i = 0; i < 5; i++){
            driver.get(url);
            mainPage.clickHeaderLoginButton();
            login(data[i][0], data[i][1]);
            Assertions.assertEquals(data[i][2], this.getTooltip(), data[i][3]);
        }
    }
    public void loginWithCorrectData(){
        MainPage mainPage = new MainPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);

        driver.get(url);
        mainPage.clickHeaderLoginButton();
        login("exitgetest@gmail.com", "Ckfdfnhele_1");
        Assertions.assertEquals("VISITATIONS", overviewPage.getHeader(),
                "Login with correct data - We are not on the Overview page");
    }
}
