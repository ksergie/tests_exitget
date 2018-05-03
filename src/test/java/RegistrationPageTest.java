import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Registration page tests")
public class RegistrationPageTest {
    @TestTemplate
    @Video(name = "Registration page. Registration with correct data")
    @DisplayName("Registration page. Registration with correct data")
    void testRegisterWithCorrectData(WebDriver driver){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerWithCorrectData();
    }

}

