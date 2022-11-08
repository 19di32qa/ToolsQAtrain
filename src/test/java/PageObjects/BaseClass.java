package PageObjects;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
    //WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dima\\Desktop\\ToolsQaProject\\src\\main\\resources\\chromedriver.exe");
        logger.info("Test is started");
    }
}
