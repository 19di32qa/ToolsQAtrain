package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RadioButtonsPage {

    WebDriver driver;
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    By like = By.id("yesRadio");
    By impressive = By.id("impressiveRadio");
    By dislike = By.cssSelector("[for=\"noRadio\"]");
    By result = By.cssSelector(".text-success");
    String url = "https://demoqa.com/radio-button";
    Actions action;
    public void getPage() {
        driver.navigate().to(url);
    }
    public void setYes() {
        action = new Actions(driver);
        action.click(driver.findElement(like)).build().perform();
    }
    public void setImpressive() {
        action = new Actions(driver);
        action.click(driver.findElement(impressive)).build().perform();
    }
    public WebElement getElem() {
        return driver.findElement(dislike);
    }
    public String getResult() {
        return driver.findElement(result).getText();
    }
}
