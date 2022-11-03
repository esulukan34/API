package Tekrar;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresBaseData;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Reqres_3 extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
    },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
      */

    @Test
    public void req03() {
        // Set The Url
        spec.pathParams("first","unknown","second",3);

        // Set The Expected  Data
        ReqresBaseData obj = new ReqresBaseData();
        Map<String,Object> expectedData = obj.expectedDataMethod(3,"true red",2002,"#BF1932","19-1664");
        System.out.println("expectedData :" + expectedData);

        Map<String,String> supportData = obj.supportDataMethod("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        System.out.println("supportData :" + supportData);

        //Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();

        // Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("id"),((Map)(actualData.get("data"))).get("id"));
        assertEquals(expectedData.get("name"),((Map)(actualData.get("data"))).get("name"));
        assertEquals(expectedData.get("year"),((Map)(actualData.get("data"))).get("year"));
        assertEquals(expectedData.get("color"),((Map)(actualData.get("data"))).get("color"));
        assertEquals(expectedData.get("pantone_value"),((Map)(actualData.get("data"))).get("pantone_value"));

        assertEquals(supportData.get("url"),((Map)(actualData.get("support"))).get("url"));
        assertEquals(supportData.get("text"),((Map)(actualData.get("support"))).get("text"));



    }
}
