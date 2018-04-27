import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerLoginButton = By.id("headerLogin");
    private By topImageRegisterButton = By.xpath("//button[@id='topImageRegister']");
    private By templateTheme = By.className("themePreviewImage");
    private By closeButton = By.id("exitget_ad_controls");
    private By footerLinks = By.xpath("//div[@id='footerLinks2']/a");
    private By footerLinks1 = By.xpath("//div[@id='footerLinks1']/a");
    private By chatBuble = By.id("chatClient");
    private By bubleTitle = By.xpath("//div[@id='chatClientHeader']/div");
    private By minimizeIcon = By.id("chatClientMinimize");
    private By cloceIcon = By.id("chatClientClose");
    private By screenshotButtons = By.xpath("//a[starts-with(@class,'screenshotOptions')]");
    private By registerButtons = By.xpath("//button[contains(@class, 'register')]");

    private List<WebElement> themeLinks = new ArrayList<>();
    private List<String> src = new ArrayList<>();

    private String[] titles = {"How to Create a Campaign - Exitget Blog",
            "About Us - Exitget",
            "Exitget Help Center",
            "Contact - Exitget",
            "Exitget. A Popup Platform for Everyone",
            "Terms of Service - Exitget",
            "Privacy Policy - Exitget",
            "Exitget.com (@exitgetcom) | Twitter",
            "Exitget - Home | Facebook"};

    private String[] srcLinks = {"//exitget.com/static/images/front/screenshots/campaign-settings-trigger-settings.png",
                                "//exitget.com/static/images/front/screenshots/campaign-settings-exit-intent.png",
                                "//exitget.com/static/images/front/screenshots/campaign-settings-display-settings.png",
                                "//exitget.com/static/images/front/screenshots/campaign-settings-animation-position.png",
                                "//exitget.com/static/images/front/screenshots/campaign-settings-validation.png"};

    private int i = 0;

    public void clickRegisterButtons(){

        Actions actions = new Actions(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        fillArray(registerButtons, "id");

        for(String s: src){
            String xpath = "//button[@id='" + s + "']";
            System.out.println("Xpath is " + xpath);
            (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            Assertions.assertEquals("Registration", registrationPage.getHeader(), "We are not on the Registration page");
            registrationPage.clickCloseIcon();
            pause(1000);
        }
    }
    public void clickScreenshotButton(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        fillArray(screenshotButtons, "path");

        int i = 0;
        for(String s : src){
            String xpath = "//a[@path='" + s + "']";
            (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            assertThat(driver.findElement(By.xpath(xpath)).getCssValue("background-color").contains("0, 135, 113"));
            xpath = "//img[@src='" + srcLinks[i] + "']";
            (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Assertions.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(),
                    "We click the " + s + " button but " + srcLinks[i] + " image was displayed");
            i++;
        }
    }

    public void clickLinks(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        fillArray(templateTheme, "src");

        for (String s : src) {
            s = s.substring(6);
            String xpath = "//img[@src='" + s + "']";
            driver.findElement(By.xpath(xpath)).click();
            pause(1000);
            (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(closeButton));
            actions.click().build().perform();
            pause(1000);
            (new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(closeButton));

        }
    }

    public void clickChatBuble() {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(chatBuble)).click();
        Assertions.assertEquals("Online Support", driver.findElement(bubleTitle).getText(), "It is not a chat window!");
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(minimizeIcon)).click();
        Assertions.assertTrue((new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(bubleTitle)),
                "The chat window is not minimalized");
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(chatBuble)).click();
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(cloceIcon)).click();
        closeAlertWindow();
        Assertions.assertTrue((new WebDriverWait(driver, 20)).until(ExpectedConditions.invisibilityOfElementLocated(chatBuble)),
                "The chat window is not closed");
    }

    public void clickFooterlinks(){

        fillArray(footerLinks, "href");

        click();

        fillArray(footerLinks1, "href");

        i = 4;
        click();
    }

    private void click(){
        for (String s: src){
            driver.get(s);
            Assertions.assertEquals(titles[i], driver.getTitle(), "The link is wrong");
            i++;
            driver.navigate().back();
        }
    }

    public void clickHeaderLoginButton() {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(headerLoginButton)).click();
    }
    public void clickTopImageRegisterButton(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(topImageRegisterButton)).click();
    }

    private void pause(int msec){
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void closeAlertWindow() {
        driver.switchTo().alert().accept();
    }

    private void fillArray(By wb, String field){
        themeLinks.clear();
        src.clear();

        List<WebElement> themeLinks = driver.findElements(wb);
        for (WebElement link : themeLinks) {
            src.add(link.getAttribute(field));
        }
    }
}
