package TestCases;

import PageObjects.BaseClass;
import PageObjects.FormPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0011_FormPage extends BaseClass {

    @Test(dataProvider = "userInfo")
    public void FormTest(String firstName,String lastName,String userEmail, String userNumber,
                         String subj,String currAddress,String state, String city) {
        WebDriver driver = new ChromeDriver();
        FormPage fp = new FormPage(driver);
        fp.getPage();
        Assert.assertTrue(fp.getElement(fp.firstName).isEnabled());
        fp.getElement(fp.firstName).sendKeys(firstName);
        fp.getElement(fp.lastName).sendKeys(lastName);
        fp.getElement(fp.userEmail).sendKeys(userEmail);
        ;
        fp.getElement(fp.userNumber).sendKeys(userNumber);
        fp.getElement(fp.currentAddress).sendKeys(currAddress);
        Actions actions = new Actions(driver);
        actions.click(fp.getElement(fp.state)).sendKeys(state).sendKeys(Keys.ENTER).build().perform();
        actions.click(fp.getElement(fp.city)).sendKeys(city).sendKeys(Keys.ENTER).build().perform();
        actions.click(fp.getElement(fp.subjectsInput)).sendKeys(subj).sendKeys(Keys.ENTER).build().perform();
        fp.getElement(fp.male).click();
        actions.click(fp.getElement(fp.sports)).build().perform();
        actions.click(fp.getElement(fp.submit)).build().perform();

        Assert.assertTrue(fp.getElement(fp.submit).isDisplayed());
    }

    @DataProvider(name = "userInfo")
    public Object[][] getData() {
        return new String[][] {{"Alex","Mercury","testToolsQA@gmail.com","1111111111","English","CurAddr","Haryana","Karnal"}};
    }

}
