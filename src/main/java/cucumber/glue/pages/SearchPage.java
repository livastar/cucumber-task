package cucumber.glue.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.glue.pages.components.RestaurantCardCollection;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.url;

@Getter
public class SearchPage extends BasePage {

    private RestaurantCardCollection restaurantCardCollection =
            new RestaurantCardCollection(driver(), ".stores .store-container");

    private SelenideElement mainIframe = $("body > iframe");
    private SelenideElement blackSeedHeaderLogo = $("header img[src*='Black_Seed']");

    private SelenideElement searchField = $("#searchBox");
    private SelenideElement searchButton = $(".searchbox-group button");
    private SelenideElement clearIcon = $("span [class*='close-circle']");
    private SelenideElement errorMessage = $(".searchbox .searchbox-help");
    private By matchedResultLocationIcon = By.cssSelector(".pac-icon");
    private By matchedResults = By.cssSelector(".pac-item-query > .pac-matched");
    private ElementsCollection searchResults = $$(".pac-container > .pac-item");

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
