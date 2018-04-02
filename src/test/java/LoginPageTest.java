import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static java.lang.System.setProperty;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Login page test")
public class LoginPageTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;

    @BeforeAll
    static void setup() {
        setProperty("wdm.edgeVersion", "3.14393");
    }

    @TestTemplate
    @Video
    @DisplayName("Login page. Login with correct data")
    void testLoginWithCorrectData(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        overviewPage = new OverviewPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget17");
        Assertions.assertEquals("VISITATIONS", overviewPage.getHeader(), "FAULT - We are not on the Overview page");
    }
    @Disabled
    @TestTemplate
    @Video
    @DisplayName("Login page. Login without data")
    void testLoginWithoutData(WebDriver driver) {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("", "");
        Assertions.assertEquals("You must provide the email address you registered with.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
    @Disabled
    @TestTemplate
    @Video
    @DisplayName("Login page. Login without password")
    void loginWithoutPasswd(WebDriver driver) {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "");
        Assertions.assertEquals("You must provide a password to login.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
    @Disabled
    @TestTemplate
    @Video
    @DisplayName("Login page. Login with incorrect email")
    void loginWithIncorrectEmail(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("123qwer", "20exitget17");
        Assertions.assertEquals("You must provide a valid email address.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
    @Disabled
    @TestTemplate
    @Video
    @DisplayName("Login page. Login with correct email and incorrect password")
    void loginWithCorrectEmailIncorrectPasswd(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget20");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
    @Disabled
    @TestTemplate
    @Video
    @DisplayName("Login page. Login with unregistered email")
    void loginWithUnregisteredEmail(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest999999@gmail.com", "20exitget17");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
}
