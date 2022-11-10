package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormPage {
    WebDriver driver;
    String url = "https://demoqa.com/automation-practice-form";
    public FormPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);

    }
   public By firstName = By.id("firstName");
   public By lastName = By.id("lastName");
   public By userEmail = By.id("userEmail");
   public By male = By.cssSelector("[for=\"gender-radio-1\"]");
   public By female = By.cssSelector("[for=\"gender-radio-2\"]");
   public By other = By.cssSelector("[for=\"gender-radio-3\"]");
   public By userNumber = By.id("userNumber");
   public By dateOfBirthInput = By.id("dateOfBirthInput");
   public By subjectsInput = By.id("subjectsInput");
   public By sports = By.id("hobbies-checkbox-1");
   public By reading = By.id("hobbies-checkbox-2");
   public By music = By.id("hobbies-checkbox-3");
   public By uploadPicture = By.id("uploadPicture");
   public By currentAddress = By.id("currentAddress");
   public By state = By.id("state");
   public By city = By.id("city");
   public By submit = By.id("submit");


   public WebElement getElement(By selector) {
       return driver.findElement(selector);
   }


}
