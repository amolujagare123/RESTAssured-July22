package MyTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class SamplePostRequestSpec2 {

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

        RequestSpecification reqPost = new RequestSpecBuilder()
                .addHeader("Content-Type","application/json").build();

        RequestSpecification request = reqPost.body("{\n" +
                "    \"name\": \"Tejas11\",\n" +
                "    \"job\": \"Test leader11\"\n" +
                "}");

        ResponseSpecification resPost = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        given().log().all().spec(reqPost)
                .when().post("/api/users")
                .then().log().all().spec(resPost);

        }

}
