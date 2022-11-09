package TestCases;

import PageObjects.BaseClass;
import PageObjects.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TC_0006_Links extends BaseClass {

    @Test
    public void LinksTest() {
        WebDriver driver = new ChromeDriver();
        LinksPage lp = new LinksPage(driver);
        driver.manage().window().maximize();
        lp.getPage();
        String mainWindow = driver.getWindowHandle();
        //Set<String> s1 = driver.getWindowHandles();
        lp.getLink(lp.Home).click();
        Set<String> s1 = driver.getWindowHandles();
        s1.remove(mainWindow);
        String nextWindow = String.valueOf(s1.iterator().next());
        driver.switchTo().window(nextWindow);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
        driver.close();
        driver.switchTo().window(mainWindow);
        lp.getLink(lp.HomeDyn).click();
        s1 = driver.getWindowHandles();
        s1.remove(mainWindow);
        driver.switchTo().window(s1.iterator().next());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.quit();
    }
}
