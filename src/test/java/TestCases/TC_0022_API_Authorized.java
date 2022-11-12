package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC_0022_API_Authorized  {
    @Test
    public void AuthorizationTest() {
        //Specify base URI
        RestAssured.baseURI="https://demoqa.com/Account/v1/Authorized";
        //Request object(whenever you want to send request to the server)
        RequestSpecification httpRequest= RestAssured.given();

        //Request payload sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("userName", "AlexM");
        requestParams.put("password", "aC12345678!");



        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toString());
        // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST);

        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);
    }


}
