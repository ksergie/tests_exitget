import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;



@ExtendWith(SeleniumExtension.class)
@DisplayName("Login page test")
public class LoginPageTests {

//    @Disabled
    @TestTemplate
    @DisplayName("Login page. Login with correct data")
    void testLoginWithCorrectData(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCorrectData();
    }

//    @Disabled
    @TestTemplate
    @DisplayName("Login page. Check Need Help? link")
    void testNeedHelpLink(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkNeedHelpLink();
    }

//    @Disabled
    @TestTemplate
    @DisplayName("Login page. Check Forgot Password? link")
    void testForgotPasswordLink(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkForgotPasswordLink();
    }

//    @Disabled
    @TestTemplate
    @DisplayName("Login page. Check Create a New One link")
    void testCreateNewOneLink(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkCreateNewOneLink();
    }
}
