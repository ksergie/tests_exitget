import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerLoginButton = By.id("headerLogin");
    private By topImageRegisterButton = By.id("topImageRegister");
    private By templateTheme = By.className("themePreviewImage");
    private By closeButton = By.id("exitget_ad_controls");


    private List<WebElement> themeLinks = new ArrayList<>();
    private List<String> src = new ArrayList<>();

    public void clickLinks(){
        Actions actions = new Actions(driver);

        List<WebElement> themeLinks = driver.findElements(templateTheme);
        for (WebElement link : themeLinks) {
            src.add(link.getAttribute("src"));
        }
        for (String s : src) {
            s = s.substring(6);
            String xpath = "//img[@src='" + s + "']";
            driver.findElement(By.xpath(xpath)).click();
            pause(700);
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(closeButton));
            actions.click().build().perform();
            pause(700);
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(closeButton));

        }
    }

    public void clickHeaderLoginButton() {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(headerLoginButton)).click();
    }
    public void clickTopImageRegisterButton(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(topImageRegisterButton)).click();
    }

    private void pause(int msec){
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
