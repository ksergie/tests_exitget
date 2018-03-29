import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static jdk.nashorn.internal.objects.NativeString.trim;


public class OverviewPage {

    private WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By header_link = By.id("header_links");

    public String getHeader() {
        return trim((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(header_link)).getText());
    }
}
