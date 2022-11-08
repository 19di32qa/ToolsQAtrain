package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTablesPage {
    private WebDriver driver;
    private String url = "https://demoqa.com/webtables";
    private By search = By.id("searchBox");
    private By addNewRecordButton = By.id("addNewRecordButton");
    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }
    public String [] names = {"Alden","Cierra","Kierra"};
    public String [] selectorsForNamesInOrder = {"//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]",
    "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div/div[1]",
    "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]/div/div[1]"};
    public void getPage() {
        driver.navigate().to(url);
    }

    public WebElement getAddNewRecordButton() {
        return driver.findElement(addNewRecordButton);
    }

    public void sortByName() {
        driver.findElement(By.xpath(" //*[ text() = \"First Name\" ]")).click();
    }
    public String getText(String selector) {
        return driver.findElement(By.xpath(selector)).getText();
    }
    public WebElement getSearchInput() {
        return driver.findElement(search);
    }

    public User user = new User("Alden","Cantrell","45","alden@example.com","12000","Compliance");

    private class User {
        String firstName;
        String lastName;
        String age;
        String email;
        String salary;
        String department;
        public User(String firstName,String lastName,String age,String email,String salary,String department) {
            this.firstName =firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
            this.salary = salary;
            this.department = department;
        }

    }
    public void setNewUser(String firstName,String lastName,String age,String email,String salary,String department) {
        getAddNewRecordButton().click();
        Actions action =new Actions(driver);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        //action.click(driver.findElement(By.id("firstName"))).sendKeys(firstName).build().perform();
        action.click(driver.findElement(By.id("lastName"))).sendKeys(lastName).build().perform();
        action.click(driver.findElement(By.id("userEmail"))).sendKeys(email).build().perform();
        action.click(driver.findElement(By.id("age"))).sendKeys(age).build().perform();
        action.click(driver.findElement(By.id("salary"))).sendKeys(salary).build().perform();
        action.click(driver.findElement(By.id("department"))).sendKeys(department).build().perform();
        action.click(driver.findElement(By.id("submit"))).build().perform();

    }

}
