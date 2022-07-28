package PayLoad;

public class SampleUser {


    public String sampleCreateUserPayLoad()
    {
       return "{\n" +
               "    \"name\": \"morpheus\",\n" +
               "    \"job\": \"leader\"\n" +
               "}";
    }

    public String sampleCreateUserPayLoad(String name,String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}
