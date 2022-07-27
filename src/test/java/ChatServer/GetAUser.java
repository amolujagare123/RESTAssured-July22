package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAUser {
    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        String userId = "109";
        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/user/"+userId)
                .then().log().all().assertThat().statusCode(200);
    }
}
