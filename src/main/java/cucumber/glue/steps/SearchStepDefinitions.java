package cucumber.glue.steps;

import com.codeborne.selenide.Condition;
import cucumber.glue.pages.RestaurantPage;
import cucumber.glue.pages.SearchPage;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;

public class SearchStepDefinitions {

    private SearchPage searchPage;

    public SearchStepDefinitions(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    @Given("an open browser page for blackseedbagels restaurant")
    public void anOpenBrowserPageForBlackseedbagelsRestaurant() {
        searchPage.open();
    }

    @When("an address {string} is entered in search field")
    public void anAddressIsEnteredInSearchField(String address) {
        searchPage.enterValueInASearchField(address);
    }

    @Then("at least one matched result should be shown bold")
    public void atLeastOneMatchedResultShouldBeShownBold() {
        searchPage.getSearchResults().shouldHave(sizeGreaterThanOrEqual(1));
        searchPage.shouldSeeMatchedSearchResults();
        searchPage.shouldSeeSearchResultsLocationIcons();
    }

    @Then("user is presented with an error: {string}")
    public void userIsPresentedWithAnError(String error) {
        searchPage.getErrorMessage().shouldHave(Condition.text(error));
    }

    @Then("there is no search results shown")
    public void thereIsNoSearchResultsShown() {
        searchPage.getSearchResults().shouldHaveSize(0);
    }

    @And("from the list user selects search result with address {string}")
    public void fromTheListUserSelectsSearchResultWithAddress(String address) {
        searchPage.getSearchField().hover();
        searchPage.getSearchResults().find(Condition.text(address.split(",")[0])).click();
    }

    @Then("restaurant card is presented the first in the list")
    public void restaurantCardIsPresentedTheFirstInTheList() {
        // searchPage.shouldSeeMatchedRestaurantCard("");
    }

    @And("user selects the card with address {string}")
    public void userSelectsTheCardWithAddress(String address) {
        // SelenideElement restaurantCard = searchPage.getRestaurantsCollections().findBy(Condition.text(address));
        // restaurantCard.
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        searchPage.getSearchButton().click();
    }
}
