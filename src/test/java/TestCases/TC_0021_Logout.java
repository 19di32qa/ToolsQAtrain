package TestCases;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import PageObjects.UserProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_0021_Logout extends BaseClass {

    @Test
    public void LogoutTest() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.getUserName().sendKeys("AlexM");
        lp.getPassword().sendKeys("aC12345678!");
        lp.getLoginBtn().click();
        Thread.sleep(3000);
        UserProfilePage up = new UserProfilePage(driver);
        up.getPage();
        driver.findElement(By.id("submit")).click();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }


}
