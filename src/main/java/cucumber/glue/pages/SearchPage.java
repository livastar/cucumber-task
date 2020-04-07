package cucumber.glue.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SearchPage extends BasePage {

    private SelenideElement mainIframe = $("body > iframe");

    private SelenideElement blackSeedHeaderLogo = $("header img[src*='Black_Seed']");

    private SelenideElement searchField = $("#searchBox");
    private SelenideElement searchButton = $(".searchbox-group button");
    private SelenideElement clearIcon = $("span [class*='close-circle']");
    private SelenideElement errorMessage = $(".searchbox .searchbox-help");
    private By matchedResultLocationIcon = By.cssSelector(".pac-icon");
    private By matchedResults = By.cssSelector(".pac-item-query > .pac-matched");
    private ElementsCollection searchResults = $$(".pac-container > .pac-item");

    private By restaurantCards = By.cssSelector(".stores > div[class*='store-container']");

    public SelenideElement getMainIframe() {
        return mainIframe;
    }

    public SelenideElement getBlackSeedHeaderLogo() {
        return blackSeedHeaderLogo;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getClearIcon() {
        return clearIcon;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public By getMatchedResultLocationIcon() {
        return matchedResultLocationIcon;
    }

    public By getMatchedResults() {
        return matchedResults;
    }

    public ElementsCollection getSearchResults() {
        return searchResults;
    }

    public RestaurantSearchCard getRestaurantsCollections() {
        // ElementsCollection restaurantSearchCards = new RestaurantSearchCardCollection(restaurantCards).collect();
        return new RestaurantSearchCard(restaurantCards);
    }

    public SearchPage open() {
        Selenide.open("/locations/blackseedbagels");
        Selenide.switchTo().frame($(mainIframe));
        $(blackSeedHeaderLogo).shouldBe(Condition.visible);
        return new SearchPage();
    }

    public String getUrl() {
        return url();
    }

    public SelenideElement enterValueInASearchField(String text) {
        return $(searchField).setValue(text);
    }

    public void shouldSeeMatchedSearchResults() {
        collectionChildrenShouldMatchCondition(getSearchResults(), matchedResults, sizeGreaterThanOrEqual(1));
    }

    public void shouldSeeSearchResultsLocationIcons() {
        collectionChildrenShouldMatchCondition(getSearchResults(), matchedResultLocationIcon, size(1));
    }

    private void collectionChildrenShouldMatchCondition(
            ElementsCollection collection,
            By childSelector,
            CollectionCondition condition) {
        collection.filter(Condition.visible).forEach(e -> e.findAll(childSelector).shouldHave(condition));
    }

    public void shouldSeeMatchedRestaurantCard(String text) {
        ElementsCollection restaurantsCollection = $$(".stores > div[class*='store-container']");
    }

    public SelenideElement getSearchButton() {
        return searchButton;
    }
}
