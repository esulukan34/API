package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees

    When
        User sends a GET Request to the url

    Then
        i) Status code is 200
    And
       ii) There are 24 employees
    And
      iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
       iv) The greatest age is 66
    And
        v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
       vi) Total salary of all employees is 6,644,770
     */

    @Test
    public void test16() {
        // Set The Url
        spec.pathParam("first", "employees");

        // 2. Set The Expected Data


        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion

        // i) Status code is 200
        assertEquals(200, response.getStatusCode());


        // ii) There are 24 employees
        response.then().assertThat().body("data.id", hasSize(24),
                // iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));


        // iv) The greatest age is 66
        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("ages = " + ages);
        Collections.sort(ages); // kucukten buyuge siraladik
        System.out.println("Sorted Ages = " + ages);
        System.out.println(ages.get(ages.size() - 1)); // En son eleman en yuksek yas demektir
        assertEquals(66, (int)(ages.get(ages.size() - 1)));

        // v) The name of the lowest age is "Tatyana Fitzpatrick"

        String lowestAgeEmployee = response.jsonPath().getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        System.out.println("lowestAgeEmployee = " + lowestAgeEmployee);

        assertEquals("[Tatyana Fitzpatrick]",lowestAgeEmployee);

        //vi) Total salary of all employees is 6,644,770

        List<Integer> employee_salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("employee_salaries = " + employee_salaries);

        // 1.yol : foreach ile
        int sum = 0;
        for (int w:employee_salaries) {
            sum += w;
        }
        System.out.println("sum = " + sum);
        assertEquals(6644770,sum);

        // 2.Yol : Lambda ile
        int sum2 = employee_salaries.stream().reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
        assertEquals(6644770,sum2);

        // 3.Yol : Math class ile
        int sum3 = employee_salaries.stream().reduce(0,Math::addExact);
        System.out.println("sum3 = " + sum3);
        assertEquals(6644770,sum3);




    }
}
