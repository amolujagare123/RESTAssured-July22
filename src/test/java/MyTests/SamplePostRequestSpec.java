package MyTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SamplePostRequestSpec {

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
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type","application/json")
                .build();

        RequestSpecification request = reqPost.body("{\n" +
                "    \"name\": \"Tejas11\",\n" +
                "    \"job\": \"Test leader11\"\n" +
                "}");

        Response res = request.when().post("/api/users");

        ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).build();


        String respString = res.then().log().all().spec(response).extract().asString();

      //  ExtractableResponse<Response> resp = res.then().log().all().spec(response).extract();



        /*

        given().log().all().spec(reqPost)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
*/
        }

}
