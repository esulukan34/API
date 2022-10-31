package Odevler;

import base_url.AutomationExerciesUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Automation extends AutomationExerciesUrl {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be "text/html; charset=utf-8"
    And
        Status Line should be HTTP/1.1 200 OK
    And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void auto() {
        // Set The Url
        spec.pathParam("first","productsList");

        // Set The Expected  Data

        // Set The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do Assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();
        // HTTP Status Code should be 200
        softAssert.assertEquals(response.statusCode(),200);

        // Content Type should be "text/html; charset=utf-8"
        softAssert.assertEquals(response.contentType(),"text/html; charset=utf-8");

        // Status Line should be HTTP/1.1 200 OK
        softAssert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
        softAssert.assertAll();

        // There must be 12 Women, 9 Men, 13 Kids usertype in products






    }
}
