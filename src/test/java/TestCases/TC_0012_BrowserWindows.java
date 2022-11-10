package TestCases;

import PageObjects.BaseClass;
import PageObjects.BrowserWindowsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TC_0012_BrowserWindows extends BaseClass {
    @Test
    public void WindowsTest() {
        WebDriver driver = new ChromeDriver();
        BrowserWindowsPage windowsPage = new BrowserWindowsPage(driver);
        windowsPage.getPage();
        String mainWindow = driver.getWindowHandle();
        driver.findElement(windowsPage.tabButton).click();
        Set<String> windows = driver.getWindowHandles();
        windows.remove(mainWindow);
        driver.switchTo().window(windows.iterator().next());
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(),"This is a sample page");
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.findElement(windowsPage.windowButton).click();
        windows = driver.getWindowHandles();
        windows.remove(mainWindow);
        System.out.println(windows);
        driver.switchTo().window(windows.iterator().next());
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(),"This is a sample page");
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.findElement(windowsPage.messageWindowButton).click();
        windows = driver.getWindowHandles();
        windows.remove(mainWindow);
        System.out.println(windows.iterator().next());
        driver.switchTo().window(windows.iterator().next());
        //Assert.assertEquals(driver.findElement(By.cssSelector("body")).getText(),"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.quit();


    }

}
