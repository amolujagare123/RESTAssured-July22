package ChatServer;

import PayLoad.ChatServer;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateUserPayload2Junit {

    @Test
    public void myMethod() {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatServer ob = new ChatServer();

        String username = "kirti";
        String password = "k123";
        String name = "kirti";
        String surname = "Bhamare";
        String nickName = "kk";
        String email = "kirthi@gmail.com";


        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body(ob.createUserPayLoad(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
