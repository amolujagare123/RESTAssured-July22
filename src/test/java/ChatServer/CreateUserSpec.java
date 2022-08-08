package ChatServer;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class CreateUserSpec {

    public static void main(String[] args) {

        /*RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body("{\n" +
                        "  \"username\": \"avinash1235\",\n" +
                        "  \"password\": \"1234\",\n" +
                        "  \"email\": \"avinash@example.org\",\n" +
                        "  \"name\": \"avinash\",\n" +
                        "  \"surname\": \"P\",\n" +
                        "  \"chat_nickname\": \"avi\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
*/
        // ----------------------------------------------------------------------------

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestChatServer = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin")
                .setAuth(auth)
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification requestCreateUser = given().log().all().spec(requestChatServer).body("{\n" +
                "  \"username\": \"avinash1235\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"email\": \"avinash@example.org\",\n" +
                "  \"name\": \"avinash\",\n" +
                "  \"surname\": \"P\",\n" +
                "  \"chat_nickname\": \"avi\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}");

        Response responseCreateUser = requestCreateUser.when().post("/restapi/user");

        ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(400).build();

        String responseStr = responseCreateUser.then().log().all().spec(response).extract().asString();

        System.out.println(responseStr);

        //----------------------- get all users ----------------

        RequestSpecification requestGetUser = given().log().all().spec(requestChatServer);

        Response responseGetUser = requestGetUser.when().get("/restapi/getusers");

        ResponseSpecification responseGet = new ResponseSpecBuilder().expectStatusCode(200).build();

        String responseGetUserStr = responseGetUser.then().log().all().spec(responseGet).extract().asString();

        System.out.println(responseGetUserStr);

    }
}
