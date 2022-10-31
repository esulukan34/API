package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulBaseData {

    public Map<String,Object> expectedDataMethod(String firstname, String lastname, Integer totalprice,Boolean depositpaid){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        //expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;
    }
}
