package JobPortal;

import POJO.CreateJobPOJO;
import POJO.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateJobPojoResp {

    @Test
    public void createJob()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        CreateJobPOJO ob = new CreateJobPOJO();
        ob.setJobDescription("Test engg");
        ob.setJobId(0);
        ob.setJobTitle("QA");
        ArrayList<String> ex = new ArrayList<>();
        ex.add("4 years");
        ob.setExperience(ex);

// ----------------------------------------------------------
        ArrayList<Project> poList = new ArrayList<>();

        Project po = new Project();
        po.setProjectName("stock management");

        ArrayList<String> tech = new ArrayList<>();
        tech.add("java");
        po.setTechnology(tech);

        poList.add(po);


        ob.setProject(poList);


        CreateJobPOJO createJobPojo = given().log().all().header("Content-Type","application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201)
                .extract().as(CreateJobPOJO.class);

        String projectName = createJobPojo.getProject().get(0).getProjectName();
        String technology = createJobPojo.getProject().get(0).getTechnology().get(0);

        System.out.println("projectName="+projectName);
        System.out.println("technology="+technology);
    }
}
