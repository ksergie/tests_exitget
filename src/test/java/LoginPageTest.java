import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SeleniumExtension.class)
public class LoginPageTest {

    MainPage mainPage;
    LoginPage loginPage;

    @TestTemplate
    public void testLoginWithCorrectData(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetester@gmail.com", "20exitget18");
    }
}
