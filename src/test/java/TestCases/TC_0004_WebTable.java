package TestCases;

import PageObjects.BaseClass;
import PageObjects.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0004_WebTable extends BaseClass {

    @Test
    public void sortTest() {
        WebDriver driver = new ChromeDriver();
        WebTablesPage wt = new WebTablesPage(driver);
        wt.getPage();
        wt.sortByName();
        for(int i =0;i<wt.names.length;i++) {
            Assert.assertEquals(wt.getText(wt.selectorsForNamesInOrder[i]),wt.names[i]);
        }
        driver.quit();
    }
    @Test
    public void searchTest() {
        WebDriver driver = new ChromeDriver();
        WebTablesPage wt = new WebTablesPage(driver);
        wt.getPage();
        wt.getSearchInput().sendKeys("Alden");
        wt.getSearchInput().sendKeys(Keys.ENTER);
        Logger logger = BaseClass.logger;
        logger.info(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div/div[1]")).getText());

        Assert.assertTrue(driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div/div[1]")).getText().equals(" "));
        driver.quit();
    }

    @Test
    public void addNewUserTest() {
        WebDriver driver = new ChromeDriver();
        WebTablesPage wt = new WebTablesPage(driver);
        wt.getPage();
        wt.setNewUser("Alex", "Merser","17","testEx@gmail.com","1345","Test");
        driver.findElement(By.xpath(" //*[ text() = \"Alex\" ]"));
        driver.findElement(By.xpath(" //*[ text() = \"Merser\" ]"));
        driver.quit();

    }
}
