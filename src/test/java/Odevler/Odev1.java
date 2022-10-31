package Odevler;

import base_url.AutomationExerciesUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev1 extends AutomationExerciesUrl {
     @Test
        public void odev1() {

            spec.pathParam("first", "productsList");

            Response response = given().spec(spec).when().get("/{first}");

            JsonPath jsonPath = response.jsonPath();

            assertEquals(200, response.statusCode());
            assertEquals("text/html; charset=utf-8", response.getContentType());
            assertEquals("HTTP/1.1 200 OK", response.statusLine());

    List<String> usertype = jsonPath.getList("products.category.usertype.usertype");

            assertEquals(12, usertype.stream().filter(t -> t.equals("Women")).count());
            assertEquals(9, usertype.stream().filter(t -> t.equals("Men")).count());
            assertEquals(13, usertype.stream().filter(t -> t.equals("Kids")).count());


    }
}
