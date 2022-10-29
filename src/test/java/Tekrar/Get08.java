package Tekrar;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonplaceholderBaseUrl {

    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
    */

    // Set The Url
    // Set The Expected Data
    // Send The Request And Get The Response
    // Do Assertion
    @Test
    public void get08() {

        // Set The Url


        // Set The Expected Data (Keylerin hepsi string fakar value'ler karisik oldugu için object sectik)
        // Expected Data --> diger adi : Payload



        // Send The Request And Get The Response


        // Do Assertion



    }
}
