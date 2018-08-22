import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SeleniumExtension.class)
@DisplayName("QuickStartGuide page test")
public class QuickStartGuidePageTest {
    @Disabled
    @TestTemplate
//    @Video(name = "QuickStartGuide page. Test")
//    @DisplayName("QuickStartGuide page. Test")
    void testQuickStartGuide(WebDriver driver){
        QuickStartGuidePage quickStartGuidePage = new QuickStartGuidePage(driver);
        quickStartGuidePage.quickStartGuide();
    }

}
