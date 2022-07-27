package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ShuffleDrawCards {

    public static void main(String[] args) {

        RestAssured.baseURI ="https://deckofcardsapi.com";

        String shuffleCardResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        System.out.println("response =" +shuffleCardResponse);

        JsonPath responseJson = new JsonPath(shuffleCardResponse);

        String deckId = responseJson.getString("deck_id");

        System.out.println("Deck ID="+deckId);

        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200);


    }
}
