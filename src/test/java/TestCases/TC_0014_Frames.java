package TestCases;

import PageObjects.BaseClass;
import PageObjects.FramesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0014_Frames extends BaseClass {

    @Test
    public void FramesTest() {
        WebDriver driver = new ChromeDriver();
        FramesPage fp = new FramesPage(driver);
        fp.getPage();
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        Assert.assertEquals(fp.getFrameText(),"This is a sample page");
        driver.switchTo().window(mainWindow);
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        Assert.assertEquals(fp.getFrameText(),"This is a sample page");
        driver.quit();

    }
}
