package MyTests;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class SamplePostRequestJson {

    @Test
    public void createUser() throws IOException {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all()
                .header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("Data/sampleCreateUser.json"))))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
