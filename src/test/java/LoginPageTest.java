import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;



@ExtendWith(SeleniumExtension.class)
public class LoginPageTest {

    private WebDriver driver;

    public LoginPageTest(WebDriver driver) {
        this.driver = driver;
    }

    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;

    @TestTemplate
    @DisplayName("Login page. Login with correct data")
    void testLoginWithCorrectData(){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        overviewPage = new OverviewPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget17");
        Assertions.assertEquals("exitgettest", overviewPage.getHeader(), "FAULT - We are not login the ExitGet");
    }

    @TestTemplate
    @DisplayName("Login page. Login without data")
    void testLoginWithoutData() {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("", "");
        Assertions.assertEquals("You must provide the email address you registered with.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @DisplayName("Login page. Login without password")
    void loginWithoutPasswd() {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "");
        Assertions.assertEquals("You must provide a password to login.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @DisplayName("Login page. Login with incorrect email")
    void loginWithIncorrectEmail(){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("123qwer", "20exitget17");
        Assertions.assertEquals("You must provide a valid email address.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @DisplayName("Login page. Login with correct email and incorrect password")
    void loginWithCorrectEmailIncorrectPasswd(){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget20");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }

    @TestTemplate
    @DisplayName("Login page. Login with unregistered email")
    void loginWithUnregisteredEmail(){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest999999@gmail.com", "20exitget17");
        Assertions.assertEquals("The login information you provided was not correct.", loginPage.getTooltip(), "FAULT - Tooltip is not correspond the user's input");
    }
}
