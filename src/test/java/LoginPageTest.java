import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import io.github.bonigarcia.SeleniumJupiter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Login page test")
public class LoginPageTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;

    @BeforeAll
    static void setup() {
        SeleniumJupiter.config().wdm().setDriverVersion("3.14393");
    }

    @TestTemplate
    @Video(name = "Login page. Login with correct data")
    @DisplayName("Login page. Login with correct data")
    void testLoginWithCorrectData(WebDriver driver){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        Assertions.assertEquals("Login", loginPage.getHeader(), "FAULT - We are not on the Login page");
        loginPage.login("exitgetest@gmail.com", "20exitget17");
        overviewPage = new OverviewPage(driver);
        Assertions.assertEquals("VISITATIONS", overviewPage.getHeader(), "FAULT - We are not on the Overview page");
    }

    @TestTemplate
    @Video(name = "Login page. Login without data")
    @DisplayName("Login page. Login without data")
    void testLoginWithoutData(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("", "");
        Assertions.assertEquals("You must provide the email address you registered with.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @Video(name = "Login page. Login without password")
    @DisplayName("Login page. Login without password")
    void loginWithoutPasswd(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "");
        Assertions.assertEquals("You must provide a password to login.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @Video(name = "Login page. Login with incorrect email")
    @DisplayName("Login page. Login with incorrect email")
    void loginWithIncorrectEmail(WebDriver driver){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("123qwer", "20exitget17");
        Assertions.assertEquals("You must provide a valid email address.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @Video(name = "Login page. Login with correct email and incorrect password")
    @DisplayName("Login page. Login with correct email and incorrect password")
    void loginWithCorrectEmailIncorrectPasswd(WebDriver driver){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget20");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @Video(name = "Login page. Login with unregistered email")
    @DisplayName("Login page. Login with unregistered email")
    void loginWithUnregisteredEmail(WebDriver driver){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest999999@gmail.com", "20exitget17");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
}
