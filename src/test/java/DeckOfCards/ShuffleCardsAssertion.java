package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ShuffleCardsAssertion {

    public static void main(String[] args) {

        RestAssured.baseURI ="https://deckofcardsapi.com";

        given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("success",equalTo(true))
                .body("remaining",equalTo(52))
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .time(lessThan(1300L), TimeUnit.MILLISECONDS);




    }
}
