package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.GamesInfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    GamesInfo gamesInfo;

    @When("User sends a GET request to games endpoint using currency parameter {string}")
    public void userSendsAGETRequestToGamesEndpointUsingCurrencyParameter(String symbolOfCurrency) {
        response = gamesInfo.getAllData(symbolOfCurrency);
    }

    @Then("User must get back with a valid status code {int}")
    public void userMustGetBackWithAValidStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }

    @And("User must get the response which contains in mentioned {string}")
    public void userMustGetTheResponseWhichContainsInMentioned(String currencySymb) {
        response.body("data.pots[0].currency",equalTo(currencySymb));
    }
}
