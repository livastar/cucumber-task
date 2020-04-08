package cucumber.glue.steps;

import cucumber.glue.pages.RestaurantPage;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantStepDefinitions {

    private RestaurantPage restaurantPage;

    public RestaurantStepDefinitions(RestaurantPage restaurantPage) {
        this.restaurantPage = restaurantPage;
    }

    @Then("user is redirected to the selected restaurant with address {string}")
    public void userIsRedirectedToTheSelectedRestaurantWithAddress(String address) {
        String formattedAddress = restaurantPage.getLocationAddress()
                .innerText().split("\n\n")[0].replace("\n", ",").split(",")[0];
        assertThat(address).contains(formattedAddress);
        restaurantPage.getUrl().contains("/black-seed-chelsea-market/menu");
    }
}
