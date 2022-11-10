package TestCases;

import PageObjects.BaseClass;
import PageObjects.DynamicProperties;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0010_DynamicProperties extends BaseClass {

    @Test
    public void DynamicPropertiesTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        DynamicProperties dp = new DynamicProperties(driver);
        dp.getPage();
        Assert.assertFalse(dp.getEnabledButton().isEnabled());
        Assert.assertEquals(dp.getChangedColorBtn().getAttribute("color"),null);
        Thread.sleep(5000);
        Assert.assertTrue(dp.getVisibleAfterBtn().isDisplayed());
        Assert.assertEquals(dp.getChangedColorBtn().getCssValue("color"),"rgba(220, 53, 69, 1)");
        Assert.assertTrue(dp.getEnabledButton().isEnabled());
        driver.quit();
    }
}
