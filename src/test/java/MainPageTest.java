import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Main page test")
public class MainPageTest {

    private MainPage mainPage;

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test theme preview images")
    @DisplayName("Main page. Test theme preview images")
    void testPreviewImages(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickLinks();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test the footers links")
    @DisplayName("Main page. Test the footers links")
    void testFooterLinks(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickFooterlinks();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test chat buble")
    @DisplayName("Main page. Test chat buble")
    void testChatBuble(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickChatBuble();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test screenshot buttons")
    @DisplayName("Main page. Test screenshot buttons")
    void testScreenshotButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickScreenshotButton();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test register buttons")
    @DisplayName("Main page. Test register buttons")
    void testRegisterButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickRegisterButtons();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test login buttons")
    @DisplayName("Main page. Test login buttons")
    void testLoginButton(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickLoginButton();
    }

//    @Disabled
    @TestTemplate
    @Video(name = "Main page. Test SignUp link")
    @DisplayName("Main page. Test SignUp link")
    void testSignupLink(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickSignupLink();
    }

    @TestTemplate
    @Video(name = "Main page. Test LOGO links")
    @DisplayName("Main page. Test LOGO links")
    void testLogoLinks(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickLogo();
    }
}
