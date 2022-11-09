package TestCases;

import PageObjects.BaseClass;
import PageObjects.LinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Optional;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

public class TC_0007_Links_Api extends BaseClass {

    @Test(dataProvider = "links")
    public void ApiCallsTest(Object url, Object message, Object code) {

//        WebDriver driver =new ChromeDriver();
//
//        LinksPage lp = new LinksPage(driver);
//        lp.getPage();
        //captureHttpRequests(driver);
        //lp.getLink(lp.no_content).click();
        //System.out.println(RestAssured.get(lp.getLink(lp.created).getAttribute("href")));
        //String link = ;
        //System.out.println(link);
        //System.out.println(httpResponseCodeViaGet("https://demoqa.com/no-content"));
        //driver.quit();

        Assert.assertEquals(httpResponseLineGet((String) url),(String) message);
        Assert.assertEquals(httpResponseCodeViaGet((String) url)+"", code);

    }

    @DataProvider(name = "links")
    public Object[][] getData() {
        return new Object[][] {{"https://demoqa.com/created","HTTP/1.1 201 Created","201"},{"https://demoqa.com/no-content","HTTP/1.1 204 No Content","204"}};
    }
    public int httpResponseCodeViaGet(String url) {
        //System.out.println(RestAssured.get(url).statusLine());
        return RestAssured.get(url).statusCode();
    }
    public String httpResponseLineGet(String url) {
        return RestAssured.get(url).statusLine();
    }

    public void captureHttpRequests(WebDriver driver) {
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
       // final String[] code = new String[1];
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(),entry->{

            logger.info(RestAssured.get(entry.getRequest().getUrl()).statusCode()+"");
            logger.info(RestAssured.get(entry.getRequest().getUrl()).statusLine());
            logger.info(entry.getRequest().getUrl());
            //logger.info(entry.getRequest().getMethod());
            //logger.info(entry.getRequest().getUrl());
            //code[0] = entry.getRequest().getUrl();

        });
       // return code[0];

    }

}
