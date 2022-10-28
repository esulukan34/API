package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik
    2) Otomasyon testleri icin de Rest Assured Library kullanacagiz
    3) Otomasyon tetslerimizi yaparken asagidaki adimlari izliyoruz:
        a) Gereksinimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacağiz. Bizler yazilim diline hakim olsak da karsimizdaki
            kisiler hakim olmayabilir ama  Gherkin ile yazilan testleri anlamak da zorluk cekmeyecektir.
            Gherkin dilinde kullanacagimiz keyword'ler;

            -Given : On kosullar,
            -When : Yapilacak aksiyonlar icin kullanacagiz( get(), put(), post(), patch() ve delete() )
            -Then : Istek yaptiktan(request gonderdikten sonra) dogrulama
            -And  : Coklu islemlerde kullanacagiz

         c) Test kodlarimizi yazmaya baslayacagiz

            i)  Set the URL,
            ii) Set the expected Data(beklenen datanin olusturulmasi, Post, Put, Patch)
            iii) Type code to send request ( Talep gondermek icin kod yazimi)
            iV) Do Assertion (Dogrulama yapmak)
     */
    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */

    @Test
    public void get01(){
        // i)  Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";
        // ii) Set the expected Data(beklenen datanin olusturulmasi, Post, Put, Patch)--> Bizden Post,Put yada Patch
        // istenmedigi icin bu case de kullanmayacagiz

        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        // iV) Do Assertion (Dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdiralim
        System.out.println("Status Code : " + response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type :" + response.getContentType());

        // Status Line konsola yazdiralim
        System.out.println("Status Line :" + response.getStatusLine());

        // Header konsola yazdiralim
        System.out.println("Header :"+ response.getHeader("Server"));

        // Headers konsola yazdiralim
        System.out.println("Headers :"+response.getHeaders());

        // Time konsola yazdiralim
        System.out.println("Time :"+ response.getTime());



    }

}
