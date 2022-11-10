package test_data;

import java.util.HashMap;
import java.util.Map;


public class ReqresBaseData {

    public Map<String,Object> expectedDataMethod(Integer id, String name, Integer year, String color, String pantone_value){

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("id",id);
        expectedData.put("name",name);
        expectedData.put("year",year);
        expectedData.put("color",color);
        expectedData.put("pantone_value",pantone_value);

        return expectedData;
    }

    public Map<String,String> supportDataMethod(String url, String text){
        Map<String,String> supportMap = new HashMap<>();
        supportMap.put("url",url);
        supportMap.put("text",text);

        return supportMap;
    }

    public String expectedDataInString(String name, String job, Integer id, String createdAt) {

        String expectedData = "{\n" +
                    "              \"name\": "+name+",\n" +
                    "              \"job\": "+job+",\n" +
                    "              \"id\": "+id+",\n" +
                    "              \"createdAt\": "+createdAt+"\n" +
                    "              }";

        return expectedData;
    }

}
