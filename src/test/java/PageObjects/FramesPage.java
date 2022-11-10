package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {
    WebDriver driver;
    String url ="https://demoqa.com/frames";

    public  FramesPage(WebDriver driver) {
        System.out.println("test");
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    //public WebElement frame1 = driver.findElement(By.id("frame1")); // can't access the element cause driver is null
    //public WebElement frame2 = driver.findElement(By.id("frame2"));
    public String getFrameText() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }
}
