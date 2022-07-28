package MyTests;

import PayLoad.SampleUser;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SamplePostRequestPayLoad {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        SampleUser ob = new SampleUser();

        given().log().all()
                .header("Content-Type","application/json")
                .body(ob.sampleCreateUserPayLoad())
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
