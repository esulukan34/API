package Odevler;

import base_url.AutomationExerciesUrl;
import base_url.SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.SwaggerPojo;
import pojos.SwaggerResponsePojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Exercies05 extends SwaggerBaseUrl {
    //5:
    /*
    https://petstore.swagger.io/ documantation adresini kullanarak 'user' oluşturan
    ve oluşan bu user'ı silen bir otomasyon kodu yazınız.
    */
/*
                    { GET :
                        "id": 123,
                        "username": "matman",
                        "firstName": "Emre",
                        "lastName": "Sulukan",
                        "email": "matman@gmail.com",
                        "password": "123456",
                        "phone": "123456",
                        "userStatus": 0
                        }
                    { POST :
                            "code": 200,
                            "type": "unknown",
                            "message": "123"
                        }
                    { DELETE :
                            "code": 200,
                            "type": "unknown",
                            "message": "matman"
                        }

 */

    @Test
    public void odev05() {
        // Set The Url
        spec.pathParams("first","v2","second","user");
        //String url = "https://petstore.swagger.io/v2/user";

        // Set The Expected Data
        SwaggerPojo expectedData = new SwaggerPojo(123,"matman","Emre","Sulukan","matman@gmail.com","123456","123456","0");
        System.out.println("expectedData = " + expectedData);

        // Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");
        SwaggerResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),SwaggerResponsePojo.class);
        System.out.println("actualData = " + actualData);

        // Do Assertion
        assertEquals(200,response.getStatusCode());
        //assertEquals(expectedData.)



    }
}
