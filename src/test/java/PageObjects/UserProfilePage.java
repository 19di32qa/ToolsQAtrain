package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePage {
    WebDriver driver;
    String url = "https://demoqa.com/profile";
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    public WebElement getBook(String book) {
        return driver.findElement(By.linkText(book));
    }
}
