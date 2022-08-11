package code;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class utils {

    public static String bookId(){

        Response response = get("/books");
        response.then().assertThat().statusCode(200);

        String bookId = response.jsonPath().getString("[0].id");

        return bookId;
    }

    public static String bearerToken(){

        String clientName = "Barisss";
        String clientEmail = "ramp@gmail.com";

        JSONObject object = new JSONObject();

        object.put("clientName",  clientName);
        object.put("clientEmail", clientEmail);

        String payload = object.toString();

        RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body(payload);
        Response generateTokenResponse = generateTokenRequest.when().post("/api-clients");

        generateTokenResponse.then().assertThat().statusCode(201);

        return "Bearer " + generateTokenResponse.jsonPath().getString("accessToken");
    }
}
