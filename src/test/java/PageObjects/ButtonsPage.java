package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    WebDriver driver;
    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }
    String url = "https://demoqa.com/buttons";
    public void getPage() {
        driver.get(url);
    }
    By doubleClickBtn = By.id("doubleClickBtn");
    By rightClickBtn = By.id("rightClickBtn");
    By dynamic = By.xpath("//*[ text() = \"Click Me\" ]");

    Actions action;

    public void setDoubleClick() {
        action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClickBtn)).build().perform();
    }
    public void setRightClickBtn() {
        action = new Actions(driver);
        action.contextClick(driver.findElement(rightClickBtn)).build().perform();
    }
    public void oneClick() {
        action = new Actions(driver);
        action.click(driver.findElement(dynamic)).build().perform();
    }
}
