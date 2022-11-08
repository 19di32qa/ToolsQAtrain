package TestCases;

import PageObjects.BaseClass;
import PageObjects.ButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0005_Buttons extends BaseClass {

    @Test
    public void ButtonsTest() {
        WebDriver driver =new ChromeDriver();
        ButtonsPage bp = new ButtonsPage(driver);
        bp.getPage();
        bp.setDoubleClick();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click");
        bp.setRightClickBtn();
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(),"You have done a right click");
        bp.oneClick();
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(),"You have done a dynamic click");
        driver.quit();
    }
}
