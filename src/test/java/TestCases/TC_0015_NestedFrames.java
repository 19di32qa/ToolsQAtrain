package TestCases;

import PageObjects.BaseClass;
import PageObjects.NestedFramesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0015_NestedFrames extends BaseClass {

    @Test
    public void NestedFramesTest() {
        WebDriver driver = new ChromeDriver();
        NestedFramesPage nf = new NestedFramesPage(driver);
        nf.getPage();
        WebElement frame = nf.getFrame("frame1");
        driver.switchTo().frame(frame);
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(),"Parent frame");
        frame = driver.findElement(By.cssSelector("[srcdoc=\"<p>Child Iframe</p>\"]"));
        driver.switchTo().frame(frame);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Child Iframe");
        driver.quit();

    }

}
