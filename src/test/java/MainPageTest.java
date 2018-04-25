import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import io.github.bonigarcia.SeleniumJupiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("Main page test")
public class MainPageTest {

    private MainPage mainPage;


    @TestTemplate
    @Video(name = "Main page. Test theme preview images")
    @DisplayName("Main page. Test theme preview images")
    void testPreviewImages(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickLinks();
    }

    @TestTemplate
    @Video(name = "Main page. Test the footers links")
    @DisplayName("Main page. Test the footers links")
    void testFooterLinks(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickFooterlinks();
    }

    @TestTemplate
    @Video(name = "Main page. Test chat buble")
    @DisplayName("Main page. Test chat buble")
    void testChatBuble(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickChatBuble();
    }
}
