package TestCases;

import PageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0019_AddBook extends BaseClass {

    @Test(dataProvider = "books")
    public void AddBookTest(String book) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage lp =new LoginPage(driver);
        lp.getPage();
        lp.getUserName().sendKeys("AlexM");
        lp.getPassword().sendKeys("aC12345678!");
        lp.getLoginBtn().click();
        Thread.sleep(3000);
        BookStorePage sp = new BookStorePage(driver);
        sp.getPage();
        sp.getBook(book).click();
        Assert.assertTrue(driver.getCurrentUrl().indexOf("https://demoqa.com/books?book")!=-1);
        BookProfile bp = new BookProfile(driver);
        WebElement el = bp.getAddToCollection();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
        //Actions action = new Actions(driver);
        //action.click(bp.getAddToCollection()).build().perform();
        //bp.getAddToCollection().click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        UserProfilePage up = new UserProfilePage(driver);
        up.getPage();
        Assert.assertTrue(up.getBook(book).isDisplayed());
        driver.quit();

    }

    @DataProvider(name = "books")
    public Object[][] getBooks() {
        return new Object[][] {{"Git Pocket Guide"}};
    }
}
