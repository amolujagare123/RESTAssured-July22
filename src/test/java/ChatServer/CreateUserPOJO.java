package ChatServer;

import POJO.ChatServerCreateUserPOJO;
import PayLoad.ChatServer;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatServerCreateUserPOJO ob = new ChatServerCreateUserPOJO();

        ob.setName("Ashwini");
        ob.setSurname("Ujagare");
        ob.setEmail("ashwini@gmail.com");
        ob.setChat_nickname("aaa");
        ob.setUsername("ashwini");
        ob.setPassword("a1234");


        ArrayList<Integer> dept = new ArrayList<>();
        dept.add(1);
        dept.add(2);
        ob.setDepartments(dept);

        ArrayList<Integer> deptRead = new ArrayList<>();
        deptRead.add(2);

        ob.setDepartments_read(deptRead);


        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1);

        ob.setUser_groups(groups);
        ob.setDepartment_groups(groups);


        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
