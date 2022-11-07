package TestCases;

import PageObjects.BaseClass;
import PageObjects.CheckBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0002_Checkbox extends BaseClass {

    //WebDriver driver = new ChromeDriver();
    @Test
    public void CheckBoxTest() {
        WebDriver driver = new ChromeDriver();
        CheckBox cb =new CheckBox();
        cb.setDriver(driver);
        cb.getPage();
        cb.setOpenTree();
        cb.setCheckBox();
        Assert.assertTrue(cb.getResult().isDisplayed());
        driver.quit();

    }

}
