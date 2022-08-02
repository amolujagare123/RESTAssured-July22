package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJob {

    @Test
    public void createJob()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"experience\": [\n" +
                        "    \"3 years\"\n" +
                        "  ],\n" +
                        "  \"jobDescription\": \"Java developer\",\n" +
                        "  \"jobId\": 0,\n" +
                        "  \"jobTitle\": \"Software engg.\",\n" +
                        "  \"project\": [\n" +
                        "    {\n" +
                        "      \"projectName\": \"Management system\",\n" +
                        "      \"technology\": [\n" +
                        "        \"java\"\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
