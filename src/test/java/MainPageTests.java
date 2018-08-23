import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Main page test")
public class MainPageTests {

    private MainPage mainPage;

//    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Main menu items")
    void testMainMenuItems(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkMainMenuLinks();
    }

//    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Sign Up buttons")
    void testSignUpButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.clickSignUpButtons();
    }

    @TestTemplate
    @DisplayName("Main page. Test the ExitGet Logo")
    void testExitGetLogo(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.clickLogoExitGet();
    }
}
