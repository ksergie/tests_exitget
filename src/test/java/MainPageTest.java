import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import io.github.bonigarcia.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
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

    @TestTemplate
    @Video(name = "Main page. Test register buttons")
    @DisplayName("Main page. Test register buttons")
    void testRegisterButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickRegisterButtons();
    }
}
