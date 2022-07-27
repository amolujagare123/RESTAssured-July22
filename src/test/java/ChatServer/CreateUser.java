package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

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
    }
}
