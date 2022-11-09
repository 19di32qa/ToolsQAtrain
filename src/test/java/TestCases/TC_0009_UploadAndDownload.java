package TestCases;

import PageObjects.BaseClass;
import PageObjects.UploadAndDownloadPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC_0009_UploadAndDownload extends BaseClass {

    @Test
    public void UploadAndDownloadTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        UploadAndDownloadPage ud = new UploadAndDownloadPage(driver);
        ud.getPage();
        ud.getDownloadBtn().click();
        Thread.sleep(5000);
        File folder = new File("C:\\Users\\Dima\\Downloads");
//List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("sampleFile.jpeg")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();

        WebElement el =ud.getUploadBtn();
        el.sendKeys("C:\\Users\\Dima\\Downloads\\sampleFile.jpeg");
        Assert.assertTrue(driver.findElement(By.id("uploadedFilePath")).isDisplayed());

        driver.quit();
    }
}
