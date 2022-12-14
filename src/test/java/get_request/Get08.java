package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonplaceholderBaseUrl {

    // De-Serialization : JsonData'yi :Java objesine cevirme
    // Serialization : Java objesini Json formatina cevirme
    // De-Serialization : Iki turlu yapacagiz
    // 1.Gson : Google tarafindan uretilmistir
    // 2.Object Mapper: Daha popüler...

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
        spec.pathParams("first","todos","second",2);

        // Set The Expected Data (Keylerin hepsi string fakar value'ler karisik oldugu için object sectik)
        // Expected Data --> diger adi : Payload
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expectedData: "+expectedData);


        // Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class); // De-Serialization [as() ile map interface'ini HashMap ile class'a cevirdik]
        System.out.println("actualData =" + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.getHeader("Via"));
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(200,response.statusCode());


    }
    @Test
    public void get08b() {

        // Set The Url
        spec.pathParams("first","todos","second",2);

        // Set The Expected Data (Keylerin hepsi string fakar value'ler karisik oldugu için object sectik)
        // Expected Data --> diger adi : Payload
        JsonPlaceHolderTestData objJsonPlcHldr = new JsonPlaceHolderTestData();

        Map<String,Object> expectedData = objJsonPlcHldr.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);

        // Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class); // De-Serialization [as() ile map interface'ini HashMap ile class'a cevirdik]
        System.out.println("actualData =" + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.getHeader("Via"));
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(200,response.statusCode());


    }

}
