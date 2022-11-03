package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulBaseData {

    public Map<String,Object> bookingdatesMethod(String checkin,String checkout){

        Map<String,Object> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

        return bookingdatesMap;
    }

    public Map<String,Object> expectedDataMethod(String firstname, String lastname, Integer totalprice,Boolean depositpaid){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);


        return expectedDataMap;
    }
}
