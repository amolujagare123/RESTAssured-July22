package util;
import io.restassured.path.json.JsonPath;

public class GetResponseString {

    public static JsonPath getResponseObject(String response)
    {
        return  new JsonPath(response);
    }
}
