import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Registration page tests")
public class RegistrationPageTest {
    @TestTemplate
    void testRegistration(WebDriver driver){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForms();
    }
//    @Disabled
    @TestTemplate
    void testClickMonthlyButton(WebDriver driver){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickMonthlyButton();
    }
//    @Disabled
    @TestTemplate
    void testClickYearlyButton(WebDriver driver){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickYearlyButton();
    }
//    @Disabled
    @TestTemplate
    void testClickSelectPlanButton(WebDriver driver){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSelectPlanButton();
    }
}

