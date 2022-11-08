package TestCases;

import PageObjects.BaseClass;
import PageObjects.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0006_Links extends BaseClass {

    @Test
    public void LinksTest() {
        WebDriver driver = new ChromeDriver();
        LinksPage lp = new LinksPage(driver);
        lp.getPage();
        lp.getLink(lp.Home).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/");
    }
}
