package TestCases;

import PageObjects.BaseClass;
import PageObjects.TextBox;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0001_TextBox extends BaseClass {

    @Test
    public void TextBoxTest() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        TextBox tb = new TextBox();
        tb.setDriver(driver);
        tb.getPage();

        tb.setFullName("Alex");
        tb.setEmail("rydootest3123@gmail.com");
        tb.setCurAddress("City1");
        tb.setPermanentAddress("City2");

        //tb.getSubmitBtn().submit();
        WebElement el = tb.getSubmitBtn();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",el);
        //tb.getSubmitBtn().click();

        Assert.assertEquals(tb.getName().getText(),"Name:Alex");
        Assert.assertEquals(tb.getEmail().getText(),"Email:rydootest3123@gmail.com");
        Assert.assertEquals(tb.getCurrentAddress().getText(),"Current Address :City1");
        Assert.assertEquals(tb.getPermanentAddres().getText(),"Permananet Address :City2");
        driver.quit();
    }




}
