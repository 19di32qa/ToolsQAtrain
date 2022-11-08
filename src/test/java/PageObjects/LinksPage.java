package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage {
    WebDriver driver;
    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }
    String url = "https://demoqa.com/links";
    public void getPage() {
        driver.navigate().to(url);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
    public By Home = By.id("simpleLink");
    public By HomeDyn = By.id("dynamicLink");
    public By created = By.id("created");
    public By no_content = By.id("no-content");
    public By moved = By.id("moved");
    public By bad_request = By.id("bad-request");
    public By unauthorized = By.id("unauthorized");
    public By forbidden = By.id("forbidden");
    public By invalid_url = By.id("invalid-url");

    public WebElement getLink(By selector) {
        return driver.findElement(selector);
    }
}
