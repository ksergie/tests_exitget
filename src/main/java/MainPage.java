import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By linksMainMenu = By.xpath("//div[@id='menuLinks']/a[@class='menuLink']");
    private By titleExitgetBlog = By.xpath("//div[@class='blogMenuRecent']/h3");
    private By buttonHeaderLogin = By.xpath("//div[@id='screenMenu']/a[1]");
    private By buttonSignUp = By.xpath("(//a[text()='SIGN UP'])[2]");
    private By buttonGetStarted1 = By.xpath("//a[@class='button green']");
    private By buttonGetStarted2 = By.xpath("(//a[text()='GET STARTED'])[2]");
    private By logoExitGet = By.id("logotext");

    private static String url = "https://exitget.com";

    public void clickHeaderLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonHeaderLogin)).click();
        wait.until(ExpectedConditions.titleIs("Login - Exitget"));
        Assertions.assertEquals("Login - Exitget", driver.getTitle(), "We are not on Login Page");
    }

    public void checkMainMenuLinks(){

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Titles of pages for checking
        String[] titlesOfPages = {
                "About Us - Exitget",
                "Exitget Blog",
                "Exitget Help Center",
                "Pricing - Exitget"
        };

        // List of Href's
        List<String> hrefs = new ArrayList<>();

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(linksMainMenu));
        // List of Menu links
        List<WebElement>menuLinks = driver.findElements(linksMainMenu);
        // Fill out href's array
        for (WebElement link: menuLinks) {
            hrefs.add(link.getAttribute("href"));
        }
        // go around the pages
        int i = 0;
        for (String href : hrefs) {
            driver.get(href);
            if (i != 1){
                wait.until(ExpectedConditions.titleIs(titlesOfPages[i]));
                String errorMessage = "We are not on the " + titlesOfPages[i] + " page";
                Assertions.assertEquals(titlesOfPages[i], driver.getTitle(), errorMessage);
            } else {
                String titleEgetBlog = wait.until(ExpectedConditions.visibilityOfElementLocated(titleExitgetBlog)).getText();
                Assertions.assertEquals(titlesOfPages[i], titleEgetBlog, "We are not on the ExitGet Blog page");
            }
            i++;
            driver.navigate().back();
        }
    }

    public void clickSignUpButtons(){
        driver.manage().window().maximize();
        driver.get(url);
        clickSignUpButton(buttonSignUp);
        clickSignUpButton(buttonGetStarted1);
        clickSignUpButton(buttonGetStarted2);
    }

    private void clickSignUpButton(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        Assertions.assertEquals("Signup for Exitget", driver.getTitle(), "We are not on the SignUp for Exitget Page");
        driver.navigate().back();
    }

    public void clickLogoExitGet(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoExitGet)).click();
        Assertions.assertEquals("Exitget. A Popup Platform for Everyone", driver.getTitle(), "Main Page. Test ExitGet Logo is failure");
    }
}
