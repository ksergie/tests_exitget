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

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the footer menu items")
    void testFooterMenuItems(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkFooterLinks();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Main menu items")
    void testMainMenuItems(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkMainMenuLinks();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Sign Up buttons")
    void testSignUpButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.clickSignUpButtons();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the ExitGet Logo")
    void testExitGetLogo(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.clickLogoExitGet();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Continue Reading button and View All link")
    void testBlogButtonAndLink(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkButtonAndLink();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Chat Client")
    void testChatClient(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkChatClient();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Screenshot Images")
    void testScreenshotMsg(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkScreenShotImg();
    }

    @Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Preview Popup buttons")
    void testPreviewPopupButtons(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkPreviewPopup();
    }

    //@Disabled
    @TestTemplate
    @DisplayName("Main page. Test the Blogs links")
    void testBlogLinks(WebDriver driver){
        mainPage = new MainPage(driver);
        mainPage.checkBlogLink();
    }
}
