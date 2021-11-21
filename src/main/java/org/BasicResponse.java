package org;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.codehaus.groovy.runtime.metaclass.MetaMethodIndex;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Vishal Tailor
 */
public class BasicResponse {
    public static String baseUrl = "https://api.github.com";

    @Test
    public void convenienceMethode() {
        // get methode
        Response response = RestAssured.get(baseUrl);
        // get the status code
        response.getStatusCode();
        // get the content type
        response.getContentType();
        // testng assert and validate the status code
        assertEquals(response.getStatusCode(), 200);
        // validate the content type
        assertEquals(response.getContentType(), "application/json; charset=utf-8");

    }

    @Test
    public void genericHeader() {
        // get methode
        // get Header always return the string
        Response response = RestAssured.get(baseUrl);
        // get header and validate
        assertEquals(response.getHeader("server"), "GitHub.com");
        // get header and validate
        assertEquals(response.getHeader("x-ratelimit-limit"), "60");
        //or covert String to int
        assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")), 60);

    }

    @Test
    public void getHeaders() {

        Response response = RestAssured.get(baseUrl);
        Headers headers = response.getHeaders();
        String val = headers.getValue("heaser1");
        int size = headers.size();
        List<Header> list = headers.asList();
        boolean isPresent = headers.hasHeaderWithName("header1");
        assertTrue(isPresent);

    }

    @Test
    public void timeExample() {
        Response response = RestAssured.get(baseUrl);
        response.getTime();
        response.getTimeIn(TimeUnit.SECONDS);
    }
    @Test
    public void getBody(){
        Response response=RestAssured.get(baseUrl);
       String body =  response.toString();
        System.out.println("data is "+ body);
    }


}
