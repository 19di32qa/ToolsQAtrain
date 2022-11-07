package TestCases;

import PageObjects.BaseClass;
import PageObjects.RadioButtonsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0003_RadioButtons extends BaseClass {

    @Test(dataProvider = "buttons")
    public void radioButtonsTest(Object test) {
        WebDriver driver = new ChromeDriver();
        RadioButtonsPage rb = new RadioButtonsPage();
        rb.setDriver(driver);
        rb.getPage();
        if(test.equals("Yes")) {
            rb.setYes();
            Assert.assertEquals(rb.getResult(), "Yes");
            driver.quit();
        }
        else if(test.equals("Impressive")) {
            rb.setImpressive();
            Assert.assertEquals(rb.getResult(), "Impressive");
            driver.quit();
        }
        else {
            Assert.assertTrue(rb.getElem().isEnabled());
            driver.quit();
        }
    }
    @DataProvider(name = "buttons")
    public Object[][] testData() {
        return new Object[][]  {{"Yes"},{"Impressive"},{"No"}};
    }

}
