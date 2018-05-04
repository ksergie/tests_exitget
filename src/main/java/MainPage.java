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
    private By loginButton = By.id("headerLogin");
    private By signUpLink = By.xpath("//div[@id='footerLinks1']/a");
    private By logoLink1 = By.xpath("//div[@id='footerInfo']/a");
    private By logoLink2 = By.id("logotext");

    private static String url = "https://exitget.com";


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



    public void clickLogo(){
        driver.get(url);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(logoLink1)).click();
        Assertions.assertEquals("Exitget. A Popup Platform for Everyone", driver.getTitle(),
                    "After clicking the Logo we did not go to main page");
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(logoLink2)).click();
        Assertions.assertEquals("Exitget. A Popup Platform for Everyone", driver.getTitle(),
                "After clicking the Logo we did not go to main page");
    }

    public void clickSignupLink(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(url);
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(signUpLink)).click();
        Assertions.assertEquals("Registration", registrationPage.getHeader(), "We are not on the Registration page");
    }

    public void clickLoginButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        driver.findElement(loginButton).click();
        Assertions.assertEquals("Login", loginPage.getHeader(), "We are not on the Login page");
    }

    public void clickRegisterButtons(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        driver.get(url);

        fillArray(registerButtons, "id");

        for(String s: src){
            String xpath = "//button[@id='" + s + "']";
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            driver.findElement(By.xpath(xpath)).click();
            Assertions.assertEquals("Registration", registrationPage.getHeader(), "We are not on the Registration page");
            registrationPage.clickCloseIcon();
            pause(1000);
        }
    }
    public void clickScreenshotButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        fillArray(screenshotButtons, "path");

        int i = 0;
        for(String s : src){
            String xpath = "//a[@path='" + s + "']";
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            driver.findElement(By.xpath(xpath)).click();
            assertThat(driver.findElement(By.xpath(xpath)).getCssValue("background-color").contains("0, 135, 113"));
            xpath = "//img[@src='" + srcLinks[i] + "']";
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            driver.findElement(By.xpath(xpath));
            Assertions.assertTrue((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed(),
                    "We click the " + s + " button but " + srcLinks[i] + " image was displayed");
            i++;
        }
    }

    public void clickLinks(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        driver.get(url);

        fillArray(templateTheme, "src");

        for (String s : src) {
            s = s.substring(6);
            String xpath = "//img[@src='" + s + "']";
            driver.findElement(By.xpath(xpath)).click();
            pause(1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
            driver.findElement(closeButton);
            actions.click().build().perform();
            pause(1000);
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(closeButton));
        }
    }

    public void clickChatBuble() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(chatBuble).click();
        Assertions.assertEquals("Online Support", driver.findElement(bubleTitle).getText(), "It is not a chat window!");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(minimizeIcon)).click();
        driver.findElement(minimizeIcon).click();
        Assertions.assertTrue((new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(bubleTitle)),
                "The chat window is not minimalized");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(chatBuble)).click();
        driver.findElement(chatBuble).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(cloceIcon)).click();
        driver.findElement(cloceIcon).click();
        closeAlertWindow();
        Assertions.assertTrue((new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(chatBuble)),
                "The chat window is not closed");
    }

    public void clickFooterlinks(){

        driver.get(url);

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
            pause(300);
            driver.navigate().back();
        }
    }

    public void clickHeaderLoginButton() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(headerLoginButton)).click();
    }
    public void clickTopImageRegisterButton(){
//        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(topImageRegisterButton)).click();
        driver.findElement(topImageRegisterButton).click();
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
