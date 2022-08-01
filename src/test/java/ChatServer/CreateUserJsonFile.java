package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserJsonFile {

    @Test
    public void createChatUser() throws IOException {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body(new String(Files.readAllBytes(Paths.get("Data/createChatUser.json"))))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
