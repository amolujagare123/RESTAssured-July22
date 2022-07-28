package MyTests;

import PayLoad.SampleUser;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SamplePostRequestPayLoad2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        SampleUser ob = new SampleUser();

        String name = "Shashi";
        String job = "Test Engg.";

        given().log().all()
                .header("Content-Type","application/json")
                .body(ob.sampleCreateUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
