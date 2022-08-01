package MyTests;


import POJO.SampleUserPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class SamplePostRequestPOJOTest {

    @Test
    public void createUser() throws IOException {

        RestAssured.baseURI = "https://reqres.in";


        SampleUserPOJO sampleUser = new SampleUserPOJO();

        sampleUser.setName("Rajesh");
        sampleUser.setJob("HR");

        given().log().all()
                .header("Content-Type","application/json")
                .body(sampleUser)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
