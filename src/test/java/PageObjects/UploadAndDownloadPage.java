package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownloadPage {
    WebDriver driver;
    String url = "https://demoqa.com/upload-download";

    public UploadAndDownloadPage(WebDriver driver){
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    public WebElement getDownloadBtn() {
        return driver.findElement(By.id("downloadButton"));
    }
    public WebElement getUploadBtn() {
        return driver.findElement(By.id("uploadFile"));
    }
}
