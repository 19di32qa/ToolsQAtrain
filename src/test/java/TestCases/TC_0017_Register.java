package TestCases;

import PageObjects.BaseClass;
import PageObjects.RegisterPage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TC_0017_Register extends BaseClass {

    @Test(dataProvider = "selectors")
    public void registerTest(String firstName, String lastName,String userName,String password, String captcha, String register) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        RegisterPage rp = new RegisterPage(driver);
        rp.getPage();
        ArrayList<LinkedList<String>> arr = ReadExelFile(); // if needed in future for many users create list of elemnts and nest it in for loop to put data from arr
        rp.getElement((String) firstName).sendKeys(arr.get(0).get(0));
        rp.getElement((String) lastName).sendKeys(arr.get(0).get(1));
        rp.getElement((String) userName).sendKeys(arr.get(0).get(2));
        rp.getElement((String) password).sendKeys(arr.get(0).get(3));
        driver.findElement(By.id("g-recaptcha")).click();
        Thread.sleep(3000);
        WebElement element =rp.getElement((String) register);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element );
        //rp.getElement((String) captcha).click();
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id((String) captcha))).click();
        //rp.getElement((String) register).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        File user = new File("C:\\Users\\Dima\\Desktop\\ToolsQaProject\\src\\main\\resources"+"\\"+userName+".txt");
        user.createNewFile();
        FileWriter writer = new FileWriter(user);
        writer.write("User info: "+ arr.get(0).get(0) +", "+arr.get(0).get(1)+", "+arr.get(0).get(2)+", "+arr.get(0).get(3));
        writer.flush();
        writer.close();
        driver.quit();



    }
    @DataProvider(name = "selectors")
    public Object[][] getSelectors() {
        return new Object[][] {{"firstname","lastname","userName","password","recaptcha-anchor","register"}};
    }


    public ArrayList<LinkedList<String>> ReadExelFile() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\ToolsQaProject\\src\\main\\resources\\usersToRegister.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("users");
        ArrayList<LinkedList<String>> arr = new ArrayList<>();
        int rows = sheet.getLastRowNum();
        for(int i =0;i<rows;i++) {
            Row row = sheet.getRow(1);
            LinkedList<String> ls = new LinkedList<>();
            for(int j =0;j<row.getLastCellNum();j++) {
                ls.add(row.getCell(j).toString());
                //System.out.println(row.getCell(j));
            }
            arr.add(ls);
        }
        //System.out.println(arr);
        return arr;

    }


}
