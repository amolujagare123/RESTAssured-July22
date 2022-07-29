package MyTests;

import PayLoad.SampleUser;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserDataProvider {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job)
    {
        RestAssured.baseURI = "https://reqres.in";
        SampleUser ob = new SampleUser();

        given().log().all().header("Content-Type","application/json")
                .body(ob.sampleCreateUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }


    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[5][2];

        data[0][0] = "Nirmala";
        data[0][1] = "Test Engg.";

        data[1][0] = "John";
        data[1][1] = "Test Lead";

        data[2][0] = "Kirti";
        data[2][1] = "Manager";

        data[3][0] = "Shashi";
        data[3][1] = "Operation Head";

        data[4][0] = "Shridhar";
        data[4][1] = "HR";

        return data;

    }

}
