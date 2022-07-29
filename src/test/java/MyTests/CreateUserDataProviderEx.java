package MyTests;

import PayLoad.SampleUser;
import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateUserDataProviderEx {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job)
    {
        RestAssured.baseURI = "https://reqres.in";
        SampleUser ob = new SampleUser();

        given().log().all().header("Content-Type","application/json")
                .body(ob.sampleCreateUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");

        // 2. convert this file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //3. identify sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for (int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
        }


      /*  data[0][0] = "Nirmala";
        data[0][1] = "Test Engg.";

        data[1][0] = "John";
        data[1][1] = "Test Lead";

        data[2][0] = "Kirti";
        data[2][1] = "Manager";

        data[3][0] = "Shashi";
        data[3][1] = "Operation Head";

        data[4][0] = "Shridhar";
        data[4][1] = "HR";*/

        return data;

    }

}
