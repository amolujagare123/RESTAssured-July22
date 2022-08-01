package ChatServer;

import PayLoad.ChatServer;
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

public class CreateUserPayloadDataProvider {

    @Test (dataProvider = "getData")
    public void createUserChat(String username,String password,String name,String surname,String nickName,String email) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatServer ob = new ChatServer();

       /* String username = "kirti";
        String password = "k123";
        String name = "kirti";
        String surname = "Bhamare";
        String nickName = "kk";
        String email = "kirthi@gmail.com";*/


        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .body(ob.createUserPayLoad(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("chat server");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

           /* data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
            data[i][3] = row.getCell(3).toString();
            data[i][4] = row.getCell(4).toString();*/

            for (int j=0;j<colCount;j++)
                data[i][j] = row.getCell(j).toString();

        }


        return data;
    }
}
