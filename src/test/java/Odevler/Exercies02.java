package Odevler;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Exercies02 extends ReqresBaseUrl {
    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                {
                                "name": "morpheus",
                                "job": "leader",
                                "id": "305",
                                "createdAt": "2022-11-08T08:39:47.070Z"
}
*/

    @Test
    public void odev02Post() {
        // Set The Url
        spec.pathParam("first", "users");

        // 2. Set The Expected Data
        ReqresPojo expectedData = new ReqresPojo("morpheus", "leader");
        System.out.println("expetecdData = " + expectedData);

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        ReqresPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),ReqresPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getJob(), actualData.getJob());

    }
}
