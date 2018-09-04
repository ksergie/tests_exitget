import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.*;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.trim;

//TODO: preview button

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By linksMainMenu = By.xpath("//div[@id='menuLinks']/a[@class='menuLink']");
    private By titleExitgetBlog = By.xpath("//div[@class='blogMenuRecent']/h3");
    private By buttonHeaderLogin = By.xpath("(//a[text()='LOGIN'])[2]");
    private By buttonSignUp = By.xpath("(//a[text()='SIGN UP'])[2]");
    private By buttonGetStarted1 = By.xpath("(//a[text()='GET STARTED'])[1]");
    private By buttonGetStarted2 = By.xpath("(//a[text()='GET STARTED'])[2]");
    private By logoExitGet = By.id("logotext");
    private By logoExitGetSmall = By.xpath("//div[@class='logotext']");
    private By linksFooter2 = By.xpath("//div[@id='footerLinks2']/a");
    private By linksFooter1 = By.xpath("//div[@id='footerLinks1']/a");
    private By buttonContinueReading = By.xpath("//a[text()='Continue Reading']");
    private By linkViewAllBlogs = By.xpath("//a[text()='VIEW ALL']");
    private By buttonChatClient = By.id("chatClient");
    private By headerChatClient = By.xpath("//div[@id='chatClientHeader']/div");
    private By buttonMinimizeChatClient = By.id("chatClientMinimize");
    private By newmsgChatClient = By.id("chatClientNewMessages");
    private By textareaChatClient = By.id("chatClientText");
    private By chatClientContent = By.id("chatClientContent");
    private By chatClientClose = By.id("chatClientClose");
    private By buttonPreviewPromo = By.id("previewPromo");
    private By promoPopupWindow = By.id("exitget_controls");
    private By iconClosePopup = By.id("exitget_close");
    private By buttonEmailMarketing = By.id("previewLeads");
    private By buttonExitIntent = By.id("previewExit");
    private By linkBlogsLinks = By.xpath("//div[@id='linkList']/a[@class='link']");
    private By linkContent = By.xpath("//div[@class='linkContent']");

    private static String url = "https://exitget.com";

    // List of Href's
    List<String> hrefs = new ArrayList<>();

    public void checkBlogLink(){
        List<String> content = new ArrayList<>();
        driver.manage().window().maximize();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(linkBlogsLinks));
        List<WebElement>blogLinks = driver.findElements(linkBlogsLinks);
        for (WebElement link: blogLinks) {
            hrefs.add(link.getAttribute("href"));
        }
        List<WebElement>contentTitles = driver.findElements(linkContent);
        for (WebElement title: contentTitles) {
            content.add(title.getText());
        }
        for (int i = 0; i < 7; i++){
            driver.get(hrefs.get(i));
            Assertions.assertEquals(trim(content.get(i)) + " - Exitget Blog", driver.getTitle(), "We are not on the " + content.get(i) + " page");
            driver.navigate().back();
        }
        hrefs.clear();
        content.clear();
    }

    public void checkPreviewPopup(){
        driver.manage().window().maximize();
        driver.get(url);
        checkPromotionalOffersButton();
        checkEmailMarketingButton();
//        checkExitIntent();
    }

    private void checkExitIntent(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonExitIntent)).click();
        moveCoursor(500, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoPopupWindow));
        wait.until(ExpectedConditions.elementToBeClickable(iconClosePopup)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(promoPopupWindow));
        Assertions.assertEquals(true, wait.until(ExpectedConditions.invisibilityOfElementLocated(promoPopupWindow)),
                "The Exit Intent Popup window is not closed after moving mouse out the page");
        moveCoursor(250, 250);
    }

    private void moveCoursor(int x, int y){
        try {
            Robot robot = new Robot();
            robot.delay(100);
            robot.mouseMove(x, y);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void checkEmailMarketingButton(){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(buttonEmailMarketing)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoPopupWindow));
        actions.click().build().perform();
        Assertions.assertEquals(true, wait.until(ExpectedConditions.invisibilityOfElementLocated(promoPopupWindow)),
                "The Email Marketing Popup window is not closed after clicking Preview Popup button");
    }
    private void checkPromotionalOffersButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(buttonPreviewPromo)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(promoPopupWindow));
        wait.until(ExpectedConditions.elementToBeClickable(iconClosePopup)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(promoPopupWindow));
        Assertions.assertEquals(true, wait.until(ExpectedConditions.invisibilityOfElementLocated(promoPopupWindow)),
                "The Promotions Popup window is not closed after clicking Close icon");
    }
    public void checkScreenShotImg(){
        String[] img = {
                "campaign-design",
                "create-design",
                "websites-hits-overview",
                "overview-screenshot"
        };
        driver.manage().window().maximize();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for(int i = 0; i < 4; i++){
            String xpath = "//a[contains(@class,'button toggle_down') and @item='" + i + "']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
            String xpathImg = "//div[@id='screenshotImages']//img[" + (i + 1) +"]";
            Assertions.assertEquals("image on", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathImg))).getAttribute("class"),
                    "The Class attribute does not equal Image On");
            Assertions.assertEquals(true, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathImg))).getAttribute("src").contains(img[i]),
                    "The wrong image is displayed");
        }

    }

    public void checkChatClient(){
        driver.manage().window().maximize();
        driver.get(url);
        openChatClient();
        minimizeChat();
        sendMsgChat();
        closeMsgChat();
    }


    private void closeMsgChat(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatClientClose)).click();
        // switch to Alert window and click the OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assertions.assertEquals(true, wait.until(ExpectedConditions.invisibilityOfElementLocated(buttonChatClient)), "Chat Client does not close correctly");
    }

    private void sendMsgChat(){
        String testMsg = "Hello Andrew! It is a test message to verify the working of the Chat Client. Sincerely your Automation test";
        openChatClient();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textareaChatClient)).sendKeys(testMsg + Keys.ENTER);
        Assertions.assertEquals(true, wait.until(ExpectedConditions.textToBePresentInElement(chatClientContent, testMsg)),
                "Chat Client does not send the message");
    }

    private void minimizeChat(){
        openChatClient();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMinimizeChatClient)).click();
        String newmsgChat = wait.until(ExpectedConditions.visibilityOfElementLocated(newmsgChatClient)).getText();
        Assertions.assertEquals("0", newmsgChat, "Minimize Chat Client is incorrect!");
    }
    private void openChatClient(){
        driver.manage().window().maximize();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonChatClient)).click();
        String headerChat = wait.until(ExpectedConditions.visibilityOfElementLocated(headerChatClient)).getText();
        Assertions.assertEquals("Online Support", headerChat, "The Chat Client does not open!");
    }

    public void clickHeaderLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonHeaderLogin)).click();
        wait.until(ExpectedConditions.titleIs("Login - Exitget"));
        Assertions.assertEquals("Login - Exitget", driver.getTitle(), "We are not on Login Page");
    }

    // Check the "Continue Reading" button and "View All" link
    public void checkButtonAndLink(){
        driver.manage().window().maximize();
        driver.get(url);
        goToBlog(buttonContinueReading);
        goToBlog(linkViewAllBlogs);
    }

    private void goToBlog(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        String titleEgetBlog = wait.until(ExpectedConditions.visibilityOfElementLocated(titleExitgetBlog)).getText();
        Assertions.assertEquals("Exitget Blog", titleEgetBlog, "We are not on the ExitGet Blog page");
        driver.navigate().back();
    }

    public void checkMainMenuLinks(){
        // Titles of pages for checking
        String[] titlesOfPages = {
                "About Us - Exitget",
                "Exitget Blog",
                "Exitget Help Center",
                "Pricing - Exitget"
        };

        driver.manage().window().maximize();
        driver.get(url);
        goAroundMenu(linksMainMenu, titlesOfPages);
    }

    public void checkFooterLinks(){
        String[] titles1 = {
                "Login - Exitget",
                "Signup for Exitget",
                "Terms of Service - Exitget",
                "Privacy Policy - Exitget",
                "Exitget.com (@exitgetcom) | Twitter",
                "Exitget - Home | Facebook"
        };
        String[] titles2 = {
                "About Us - Exitget",
                "Exitget Blog",
                "Pricing - Exitget",
                "Exitget Help Center",
                "Contact - Exitget"
        };

        driver.manage().window().maximize();
        driver.get(url);
        goAroundFooterLinks(linksFooter1, titles1);
        goAroundMenu(linksFooter2, titles2);
    }

    private void goAroundFooterLinks(By xpathFooter, String titles[]){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathFooter));
        // List of Menu links
        List<WebElement>menuLinks = driver.findElements(xpathFooter);
        // Fill out href's array
        for (WebElement link: menuLinks) {
            hrefs.add(link.getAttribute("href"));
        }
        // go around the pages
        int i = 0;
        for (String href : hrefs) {
            driver.get(href);
            wait.until(ExpectedConditions.titleIs(titles[i]));
            String errorMessage = "We are not on the " + titles[i] + " page";
            Assertions.assertEquals(titles[i], driver.getTitle(), errorMessage);
            i++;
            driver.navigate().back();
        }
        hrefs.clear();
        menuLinks.clear();

    }

    public void clickSignUpButtons(){
        driver.manage().window().maximize();
        driver.get(url);
        clickSignUpButton(buttonGetStarted1);
        clickSignUpButton(buttonGetStarted2);
        clickSignUpButton(buttonSignUp);

    }

    private void clickSignUpButton(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
        wait.until(ExpectedConditions.titleIs("Signup for Exitget"));
        driver.navigate().back();
        wait.until(ExpectedConditions.titleIs("Exitget. A Popup Platform for Everyone"));
    }

    public void clickLogoExitGet(){
        driver.manage().window().maximize();
        driver.get(url);
        clickLogo(logoExitGet);
        clickLogo(logoExitGetSmall);
    }

    private void clickLogo(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).click();
        Assertions.assertEquals("Exitget. A Popup Platform for Everyone", driver.getTitle(), "Main Page. Test ExitGet Logo is failure");
    }

    private void goAroundMenu(By xpathLinks, String[] titles){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathLinks));
        // List of Menu links
        List<WebElement>menuLinks = driver.findElements(xpathLinks);
        // Fill out href's array
        for (WebElement link: menuLinks) {
            hrefs.add(link.getAttribute("href"));
        }
        // go around the pages
        int i = 0;
        for (String href : hrefs) {
            driver.get(href);
            if (i != 1){
                wait.until(ExpectedConditions.titleIs(titles[i]));
                String errorMessage = "We are not on the " + titles[i] + " page";
                Assertions.assertEquals(titles[i], driver.getTitle(), errorMessage);
            } else {
                String titleEgetBlog = wait.until(ExpectedConditions.visibilityOfElementLocated(titleExitgetBlog)).getText();
                Assertions.assertEquals(titles[i], titleEgetBlog, "We are not on the ExitGet Blog page");
            }
            i++;
            driver.navigate().back();
        }
        hrefs.clear();
        menuLinks.clear();
    }

}
