package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBox {
    private WebDriver driver;
    private By fullName = By.cssSelector("#userName");
    private By email = By.id("userEmail");
    private By CurAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitBtn = By.cssSelector("#submit");

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get("https://demoqa.com/text-box");
    }
    public void setFullName(String name) {
        driver.findElement(fullName).sendKeys(name);
    }
    public void setEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }
    public void setCurAddress(String addr) {
        driver.findElement(CurAddress).sendKeys(addr);
    }
    public void setPermanentAddress(String addr) {
        driver.findElement(permanentAddress).sendKeys(addr);
    }
    public WebElement getSubmitBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitBtn)));
        return el;

    }

    public WebElement getName() {
        return driver.findElement(By.cssSelector("p#name"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.cssSelector("p#email"));
    }
    public WebElement getCurrentAddress() {
        return driver.findElement(By.cssSelector("p#currentAddress"));
    }
    public WebElement getPermanentAddres() {
        return driver.findElement(By.cssSelector("p#permanentAddress"));
    }

}
