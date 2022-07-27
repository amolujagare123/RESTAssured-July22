package MyTests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SamplePutRequest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        String userId="2";

        given().log().all()
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when().put("/api/users/"+userId)
                .then().log().all().assertThat().statusCode(200);
    }
}
