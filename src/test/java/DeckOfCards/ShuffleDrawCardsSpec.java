package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static util.GetResponseString.getResponseObject;

public class ShuffleDrawCardsSpec {

    public static void main(String[] args) {

      /*  RestAssured.baseURI ="https://deckofcardsapi.com";

        String shuffleCardResponse = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        System.out.println("response =" +shuffleCardResponse);

        JsonPath responseJson = new JsonPath(shuffleCardResponse);

        String deckId = responseJson.getString("deck_id");
// --------------------------------------------------------------------------------------------------------
        System.out.println("Deck ID="+deckId);

        given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200);

// --------------------------------------------------------------------------------------------------------
*/
        RequestSpecification requestCards = new RequestSpecBuilder()
                .setBaseUri("https://deckofcardsapi.com").build();


        RequestSpecification requestShuffleCards = given().log().all().spec(requestCards).
                queryParam("deck_count", "1");

        Response responseShuffle = requestShuffleCards.when().get("/api/deck/new/shuffle/");

        ResponseSpecification responseCards = new ResponseSpecBuilder().expectStatusCode(200).build();

        String responseStr = responseShuffle.then().log().all().spec(responseCards).extract().asString();

        String deckID = getResponseObject(responseStr).getString("deck_id");

        // --------------------------------------------------------


        RequestSpecification requestDrawCards = given().log().all().spec(requestCards).
                queryParam("count", "2");

        Response responseDrawCards = requestDrawCards.when().get("/api/deck/" + deckID + "/draw/");

        String responseDrawCardsStr = responseDrawCards.then().log().all().spec(responseCards).extract().asString();

        System.out.println(responseDrawCardsStr);
    }
}
