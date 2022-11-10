package Odevler;

import base_url.AutomationExerciesUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Exercies01 extends AutomationExerciesUrl {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void odev01() {
        // Set The Url
        spec.pathParam("first", "brandsList");

        // 2. Set The Expected Data

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");


        JsonPath jsonPath = response.jsonPath();
        //jsonPath.prettyPrint();


        // Do Assertion
        assertEquals(200, response.getStatusCode());
        assertEquals("text/html; charset=utf-8", response.contentType());
        assertEquals("HTTP/1.1 200 OK", response.statusLine());

        List<String> Polo = jsonPath.getList("brands.findAll{it.brand =='Polo'}.brand");
        System.out.println("Polo = " + Polo);
        List<String> HM = jsonPath.getList("brands.findAll{it.brand =='H&M'}.brand");
        System.out.println("HM = " + HM);
        assertNotEquals(Polo.size(), HM.size());


    }
}
