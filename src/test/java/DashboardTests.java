import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SeleniumExtension.class)
@DisplayName("Dashboard page test")
public class DashboardTests {
    @Disabled
    @TestTemplate
//    @Video(name = "Dashboard page. Click the menu items")
//    @DisplayName("Dashboard page. Click the menu items")
    void testMenuItems(WebDriver driver){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuItems();
    }
}
