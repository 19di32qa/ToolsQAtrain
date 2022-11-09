package TestCases;

import PageObjects.BaseClass;
import PageObjects.BrokenLinksPage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Base64;

public class TC_0008_BrokenLinks extends BaseClass {

    @Test
    public void BrokenLinksTest() throws IOException {
        WebDriver driver =new ChromeDriver();
        BrokenLinksPage bl = new BrokenLinksPage(driver);
        bl.getPage();
        HttpClient client = HttpClientBuilder.create().build();
        WebElement valImg = bl.getElement(bl.validImage);
        HttpGet request = new HttpGet(valImg.getAttribute("src"));
        HttpResponse response = client.execute(request);
        /* For valid images, the HttpStatus will be 200 */
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        WebElement invalImg = bl.getElement(bl.invalidLink);
        HttpGet request2 = new HttpGet(invalImg.getAttribute("href"));
        HttpResponse response2 = client.execute(request2);
        System.out.println(response2.getStatusLine().getStatusCode());
        Assert.assertTrue(response2.getStatusLine().getStatusCode() != 200);
        driver.quit();

    }


}
