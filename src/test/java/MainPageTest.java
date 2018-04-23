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

    @BeforeAll
    static void setup(EdgeDriver driver) {
        SeleniumJupiter.config().wdm().setDriverVersion("3.14393");
    }

    @TestTemplate
    @Video(name = "Main page. Test theme preview images")
    @DisplayName("Main page. Test theme preview images")
    void testPreviewImages(WebDriver driver){
        mainPage = new MainPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickLinks();
    }
}
