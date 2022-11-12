package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookProfile {

    WebDriver driver;

    public BookProfile(WebDriver driver) {
        this.driver = driver;
    }
    public String[] fields = {"userName-value"};
    public WebElement getField(String selector) {
        return driver.findElement(By.xpath(selector));
    }
    public WebElement getBackStoreBtn() {
        return driver.findElement(By.cssSelector(".text-left"));
    }
    public WebElement getAddToCollection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right #addNewRecordButton")));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")));
        //return driver.findElement(By.cssSelector(".text-right #addNewRecordButton"));
    }
}
