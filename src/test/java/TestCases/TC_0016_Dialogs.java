package TestCases;

import PageObjects.BaseClass;
import PageObjects.Dialogs;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0016_Dialogs extends BaseClass {

    @Test
    public void DialogsTest() {

        WebDriver driver =new ChromeDriver();
        Dialogs dialogs = new Dialogs(driver);
        dialogs.getPage();
        WebElement element = dialogs.getSmallModal();
        element.click();
        Assert.assertEquals(dialogs.getModalBody().getText(),"This is a small modal. It has very less content");
        dialogs.getSmallModalBtn().click();
        dialogs.getLargeModal().click();
        //System.out.println(driver.findElement(By.cssSelector(".modal-body p")));
        //Assert.assertEquals(driver.findElement(By.cssSelector(".modal-body p")).getText(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        driver.findElement(By.id("closeLargeModal")).click();
        driver.quit();

    }
}
