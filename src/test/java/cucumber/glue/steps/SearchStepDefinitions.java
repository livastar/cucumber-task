package cucumber.glue.steps;

import cucumber.glue.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    private SearchPage searchPage;

    public SearchStepDefinitions(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    @Given("an open browser page for blackseedbagels restaurant")
    public void an_open_browser_page_for_blackseedbagels_restaurant() {
        searchPage.open();
        searchPage.shouldSeeTheLogo();
    }

    @When("a valid address {string} is entered in search field")
    public void a_valid_address_is_entered_in_search_field(String address) {
        searchPage.enterValueInASearchField(address);
    }

    @Then("at least one matched result should be shown bold")
    public void at_least_one_matched_result_should_be_shown_bold() {
        assertThat(searchPage.searchResults().size()).isGreaterThanOrEqualTo(1);
        searchPage.shouldSeeMatchedSearchResults();
        searchPage.shouldSeeSearchResultsLocationIcons();
    }

    @Then("clicking at first matched result")
    public void clicking_at_first_matched_result() {

    }

    @Then("user should be at restaurant with address {string}")
    public void user_should_be_at_restaurant_with_address(String string) {

    }
}

