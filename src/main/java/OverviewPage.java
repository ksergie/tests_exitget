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

    private By header_link = By.xpath("(//div[@id='stats_highlight']//div[@class='helptext'])[1]");
    private By quickstart_sub_item = By.xpath("//a[@class='dashboard_quickstart sub_item']");
    private By accountButton = By.id("accountButton");
    private By userNameString = By.id("header_links");

    public String getHeader() {
        return trim((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(header_link)).getText());
    }

    public String getUserNameString() {
        return trim((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(userNameString)).getText());
    }

    public void clickQuickstartItem(){
        driver.findElement(quickstart_sub_item).click();
    }

    public void clickAccountButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(accountButton)).click();
    }
}
