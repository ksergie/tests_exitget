import io.github.bonigarcia.SeleniumExtension;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Login page test")
public class LoginPageTests {

    @TestTemplate
//    @Video(name = "Login page. Login with correct data")
//    @DisplayName("Login page. Login with correct data")
    void testLoginWithCorrectData(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCorrectData();
    }

//    @Disabled
//    @TestTemplate
////    @Video(name = "Login page. Login with incorrect data")
////    @DisplayName("Login page. Login with incorrect data")
//    void testLoginWithIncorrectData(WebDriver driver) {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginWithIncorrectData();
//    }
}
