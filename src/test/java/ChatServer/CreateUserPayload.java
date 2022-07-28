package ChatServer;

import PayLoad.ChatServer;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUserPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatServer ob = new ChatServer();


        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body(ob.createUserPayLoad())
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
