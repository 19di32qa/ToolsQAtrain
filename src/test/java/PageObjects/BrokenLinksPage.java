package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksPage {
    WebDriver driver;
    String url = "https://demoqa.com/broken";
    public BrokenLinksPage(WebDriver driver) {
        this.driver = driver;
    }
    public By validImage = By.cssSelector("[src=\"/images/Toolsqa.jpg\"]");
    public By invalidImage = By.cssSelector("[src=\"/images/Toolsqa_1.jpg\"]");

    public By validlink = By.linkText("Click Here for Valid Link");
    public By invalidLink = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a[2]");
    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }
    public void getPage() {
        driver.navigate().to(url);
    }
}
