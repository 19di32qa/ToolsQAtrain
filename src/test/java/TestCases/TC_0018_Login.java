package TestCases;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0018_Login extends BaseClass {

    @Test(dataProvider = "UserInfo")
    public void loginTest(String name, String password) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.getUserName().sendKeys(name);
        lp.getPassword().sendKeys(password);
        lp.getLoginBtn().click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        driver.quit();
    }
    @DataProvider(name = "UserInfo")
    public Object[][] getData() {
        return  new Object[][] {{"AlexM","aC12345678!"}};
    }
}
