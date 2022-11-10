package PageObjects;

import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    WebDriver driver;
    String url = "https://demoqa.com/nestedframes";
    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }
}
