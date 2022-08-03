package MyTests;


import POJO.SampleCreateUserResponsePOJO;
import POJO.SampleUserPOJO;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SamplePostRequestPOJOResponse {

    @Test
    public void createUser() throws IOException {

        RestAssured.baseURI = "https://reqres.in";


        SampleUserPOJO sampleUser = new SampleUserPOJO();

        sampleUser.setName("Rajesh");
        sampleUser.setJob("HR");

        SampleCreateUserResponsePOJO respObject = given().log().all()
                .header("Content-Type", "application/json")
                .body(sampleUser)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201).extract().as(SampleCreateUserResponsePOJO.class);

                System.out.println("name="+respObject.getName());
                System.out.println("job="+respObject.getJob());
                System.out.println("id="+respObject.getId());
                System.out.println("createdAt="+respObject.getCreatedAt());



    }
}
