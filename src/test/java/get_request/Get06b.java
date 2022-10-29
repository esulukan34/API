package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get06b extends ReqresBaseUrl {
     /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200 --> Durum kodu 200
        2)Print all pantone_values --> Tüm pantone_değerlerini yazdır
        3)Print all ids greater than 3 on the console --> Konsolda 3'ten büyük tüm kimlikleri yazdır
          Assert that there are 3 ids greater than 3 --> 3'ten büyük 3 kimlik olduğunu iddia edin
        4)Print all names whose ids are less than 3 on the console --> Kimlikleri 3'ten küçük olan tüm adları konsolda yazdırın
          Assert that the number of names whose ids are less than 3 is 2 --> Kimlikleri 3'ten küçük olan isimlerin sayısının 2 olduğunu iddia edin.
*/

    @Test
    public void get06() {
        // Set The Url
        spec.pathParam("first", "unknown");


        // Set The Expected Data

        // Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().body("data",hasSize(6));


        // Do Assertion
        // 1.Status code is 200
        assertEquals(200,response.getStatusCode());

        // 2.Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        jsonPath.getList("data.pantone_value"); // --> pantone_value, list halinde verecek
        System.out.println(jsonPath.getList("data.pantone_value").size());

        // 3.Print all ids greater than 3 on the console
        System.out.println(jsonPath.getList("data.id"));
        // List<Integer> ids =jsonPath.getList("data.id");
        // for (int i = 0; i < ids.size(); i++) {
        //     if (ids.get(i)>3){
        //         System.out.println(i+ ".id:" +ids.get(i));

        //     }
        // }
        List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("ids = " + ids);
        assertEquals(3,ids.size());


        // 4)Print all names whose ids are less than 3 on the console
        List<String> names = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("names = " + names);
        // Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,names.size());


    }
}
