package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to("https://demoqa.com/checkbox");
    }
    By inputHome = By.cssSelector("[for=\"tree-node-home\"]");

    By openTree = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    By openDesctop =By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button/svg");
    By checkBox = By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg");
    By result = By.id("result");

    public void setOpenTree() {
        driver.findElement(openTree).click();
    }
    public void setOpenDesctop() {
        driver.findElement(openDesctop).click();
    }
    public void setCheckBox() {
        driver.findElement(checkBox).click();
    }
    public WebElement getCheckBox() {
        return driver.findElement(checkBox);
    }
    public WebElement getResult() {
        return driver.findElement(result);
    }


}
