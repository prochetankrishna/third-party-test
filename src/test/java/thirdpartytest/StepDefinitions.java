package thirdpartytest;

import io.cucumber.java.en.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private static final String BASE_URI = "http://43.205.243.206:8095/api";
    private static RequestSpecification lookupRequestSpecification;
    private static Response lookUpResponse;
    @Given("Lookup Request is sent to Broker Service")
    public void lookup_request_is_sent_to_broker_service() {
        RestAssured.baseURI = BASE_URI;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.log().all();
        String requestBody = "{\n" +
                "    \"sessionId\" : \"ABC\",\n" +
                "    \"pdeId\" : \"123\",\n" +
                "    \"phoneNumber\" : \"8373987300\"\n" +
                "}";
        requestSpecification.body(requestBody);
        lookupRequestSpecification = requestSpecification;
    }
    @When("POST method is called")
    public void post_method_is_called() {
        lookUpResponse = lookupRequestSpecification.post("/internal/lookup");
    }
    @Then("Server should response with successful lookup and with recommendation to block")
    public void server_should_response_with_successful_lookup_and_with_recommendation_to_block() {
        String lookUpResponseBody = lookUpResponse.then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath lookUpResponseJson = new JsonPath(lookUpResponseBody);
        String recommendation = lookUpResponseJson.getString("risk.recommendation");
        assertEquals(recommendation, "block");
    }

}
