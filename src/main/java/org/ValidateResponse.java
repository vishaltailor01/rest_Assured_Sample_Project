package org;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

/**
 * @author Vishal Tailor
 */
public class ValidateResponse {
    public static String baseUrl = "https://api.github.com";

    @Test
    public void basicValidationExample(){
        RestAssured.get(baseUrl)
                .then()
                .assertThat()
                .statusCode(200)
                .and() // syntactic sugar code
                .contentType(ContentType.JSON)
                .and().assertThat() // syntactic sugar code
                .header("x-ratelimit-limit","60");
    }
}
