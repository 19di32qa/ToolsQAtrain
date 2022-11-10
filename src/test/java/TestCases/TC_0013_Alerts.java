package TestCases;

import PageObjects.AlertsPage;
import PageObjects.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_0013_Alerts extends BaseClass {
    @Test
    public void AlertsTest() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        AlertsPage ap = new AlertsPage(driver);
        ap.getPage();
        ap.getElement(ap.alertButton).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),"You clicked a button");
        driver.switchTo().alert().accept();
        ap.getElement(ap.timerAlertButton).click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        ap.getElement(ap.confirmButton).click();
        driver.switchTo().alert().accept();
        ap.getElement(ap.confirmButton).click();
        driver.switchTo().alert().dismiss();
        //Click the link to activate the alert
        ap.getElement(ap.promtButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //Type your message
        alert.sendKeys("Selenium");
        //Press the OK button
        alert.accept();
        Assert.assertTrue(ap.getElement(By.id("promptResult")).getText().indexOf("Selenium")!=-1);
        driver.quit();

    }
}
