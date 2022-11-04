package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10 ==> "Sayfalandırma sınırı" değeri 10'dur
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        ==> "Geçerli bağlantı", "https:gorest.co.inpublicv1users?page=1" olmalıdır
    And
        The number of users should  be 10 ==> Kullanıcı sayısı 10 olmalıdır
    And
        We have at least one "active" status ==> En az bir "etkin" durumumuz var
    And
        "Navin Panicker", "Pres. Amarnath Dhawan" and "Sujata Chaturvedi"  are among the users
        ==> Niranjan Gupta, Sameer Namboothiri ve Gandharva çağrısı kullanıcılar arasında
    And
        The female users are less than or equals to male users
        ==> Kadın kullanıcılar erkek kullanıcılara eşit veya daha az
 */

    @Test
    public void test11() {
        // Set The Url
        spec.pathParam("first","users");

        // 2. Set The Expected Data (put, post, patch)

        // 3. Send The  Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker"));

        // Kadın ve erkek sayılarını karsilastiralim
        // 1.Yol: for loop
        List<String> genders = response.jsonPath().getList("data.gender");
        System.out.println(genders);
        int numFemale = 0;
        for (String w : genders) {

            if(w.equalsIgnoreCase("female")){
                numFemale++;
            }
        }
        assertTrue(numFemale<=genders.size()-numFemale);

        // 2.Yol : Kadin ve erkek sayilarini Groovy ile bulalim

        List<String> femaleGender = response.jsonPath().getList("data.findAll{it.gender =='female'}.gender");
        System.out.println(femaleGender);

        assertTrue(femaleGender.size()<= genders.size());

        // 3.Yol
        JsonPath jsonPath = response.jsonPath();
        assertTrue(jsonPath.
                getList("data.findAll{it.gender='female'}").size()<=jsonPath.getList("data.findAll{it.gender='male'}").size());

    }
}
