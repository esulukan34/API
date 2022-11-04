package Tekrar;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonplaceholderBaseUrl {
    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/142
     2) {
            "userId": 29,
            "title": "If you belive everything happens",
            "completed": false
          }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 29,
                   "title": "If you belive everything happens",
                   "completed": false
                   "id": 142
                  }
 */

    @Test
    public void put02() {
        // Set The Url
        spec.pathParams("first","todos","second",142);

        // Set The Expected  Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMethod(29,"If you belive everything happens",false);


        // Set The Request and Get The Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        assertEquals(200,response.getStatusCode());
        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
    }
}
