package MyTests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SamplePostRequest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all()
                .header("Content-Type","application/json")
                .body("{\n" +
                "    \"name\": \"Tejas\",\n" +
                "    \"job\": \"Test leader\"\n" +
                "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
