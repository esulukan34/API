package Tekrar;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends RestfulBaseUrl {
        /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

        */

    @Test
    public void get04() {
        // Set The Url

        // Set The Expected Data

        // Set The Request and Get The Response


        // Do Assertion

        //assertTrue(response.prettyPrint().contains("bookingid")); --> bu da oluyor

    }
}
