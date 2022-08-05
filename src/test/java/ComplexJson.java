import PayLoad.JsonPayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PayLoad.JsonPayLoad.getJsonPayload;

public class ComplexJson {

    @Test
    public void jasonPayloadTest()
    {
        String response = getJsonPayload();

        JsonPath js = new JsonPath(response);

        //1. Print No of courses returned by API
        int totalCourses = js.getInt("courses.size()");
        System.out.println("No of courses = "+totalCourses);

        //2.Print Purchase Amount
        int purchaseAmount = js.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount"+purchaseAmount);


        // 3. Print Title of the first course
        String title = js.getString("courses[0].title");
        System.out.println("title="+title);

        System.out.println("Below are courses and their prices");
        // 4. Print All course titles and their respective Prices
        for (int i=0;i<totalCourses;i++) {
            System.out.print("Course Name="+js.getString("courses["+i+"].title"));
            System.out.println("\t|\tprice="+js.getString("courses["+i+"].price"));

        }


        // 5. Print no of copies sold by RPA Course

        for (int i=0;i<totalCourses;i++) {

            if (js.getString("courses[" + i + "].title").equals("RPA"))
            {
                System.out.print("Course Name="+js.getString("courses["+i+"].title"));
                System.out.println("\t|\tNo of Copies sold="+js.get("courses[" + i + "].copies"));
            }


        }

        // 6. Verify if Sum of all Course prices matches with Purchase Amount

        int sum = 0;

        for (int i=0;i<totalCourses;i++) {

           sum = sum + js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");

        }

        System.out.println("Sum="+sum);

        Assert.assertEquals(sum,purchaseAmount);
    }



}
