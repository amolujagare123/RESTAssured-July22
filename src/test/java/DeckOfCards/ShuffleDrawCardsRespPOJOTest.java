package DeckOfCards;

import POJO.ShuffleCardsRespPOJO;
import POJO.deckofcards.Cards;
import POJO.deckofcards.DrawCardsRespPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ShuffleDrawCardsRespPOJOTest {

    @Test
    public void deckOfCardsTest()
    {
        RestAssured.baseURI="https://deckofcardsapi.com";

        ShuffleCardsRespPOJO shuffleCardsResp = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(ShuffleCardsRespPOJO.class);

        String deckID = shuffleCardsResp.getDeck_id();
        System.out.println("deck id = "+deckID);

        DrawCardsRespPOJO drawCardsRespPOJO = given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckID+"/draw/")
                .then().log().all().assertThat().statusCode(200)
                 .extract().as(DrawCardsRespPOJO.class);


        String firstCardImagePath = drawCardsRespPOJO.getCards().get(0).getImages().getPng();
        String firstCardImagePath1 = drawCardsRespPOJO.getCards().get(0).getImage();

        System.out.println(firstCardImagePath1);


    }
}
