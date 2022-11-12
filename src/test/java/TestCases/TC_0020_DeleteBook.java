package TestCases;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import PageObjects.UserProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_0020_DeleteBook extends BaseClass {

    @Test
    public void deleteBookTest() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.getUserName().sendKeys("AlexM");
        lp.getPassword().sendKeys("aC12345678!");
        //Thread.sleep(2000);
        lp.getLoginBtn().click();
        UserProfilePage up = new UserProfilePage(driver);
        //driver.switchTo().window()
        Thread.sleep(3000);
        up.getPage();
        //System.out.println(driver.getCurrentUrl());
        //System.out.println(up.getBook("Git Pocket Guide"));
        //System.out.println(driver.getWindowHandles());
        if(driver.findElements(By.linkText("Git Pocket Guide")).isEmpty()) {
            driver.quit();
        }else {
            driver.findElement(By.id("delete-record-undefined")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("closeSmallModal-ok"))).click();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.quit();
        }


    }

}
