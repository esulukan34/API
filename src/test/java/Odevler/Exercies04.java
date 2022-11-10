package Odevler;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Exercies04 extends ReqresBaseUrl {
    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.
  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                    "name": "neo",
                    "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void odev04Patch() {
        // Set The Url
        spec.pathParams("first", "users","second",2);

        // Set The Expected  Data
        ReqresPojo expectedData = new ReqresPojo("neo",null);
        System.out.println("expectedData = " + expectedData);

        // Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        ReqresPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),ReqresPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getName(), actualData.getName());



    }
}
