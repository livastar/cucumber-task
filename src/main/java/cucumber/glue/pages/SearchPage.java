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

public class SearchPage {

    private static final By MAIN_IFRAME = By.cssSelector("body > iframe");

    private static final By BLACK_SEED_HEADER_LOGO = By.cssSelector("header img[src*='Black_Seed']");
    private static final By SEARCH_FIELD = By.cssSelector("#searchBox");
    private static final By SEARCH_RESULTS = By.cssSelector(".pac-container > .pac-item");
    private static final By MATCHED_RESULTS = By.cssSelector(".pac-item-query > .pac-matched");
    private static final By MATCHED_RESULT_LOCATION_ICON = By.cssSelector(".pac-icon");

    public SearchPage open() {
        Selenide.open("/locations/blackseedbagels");
        Selenide.switchTo().frame($(MAIN_IFRAME));
        $(BLACK_SEED_HEADER_LOGO).shouldBe(Condition.visible);
        return new SearchPage();
    }

    public String getUrl() {
        return url();
    }

    public SelenideElement enterValueInASearchField(String text) {
        return $(SEARCH_FIELD).setValue(text);
    }

    public ElementsCollection searchResults() {
        return $$(SEARCH_RESULTS);
    }

    public void shouldSeeMatchedSearchResults() {
        collectionChildrenShouldMatchCondition(searchResults(), MATCHED_RESULTS, sizeGreaterThanOrEqual(1));
    }

    public void shouldSeeSearchResultsLocationIcons() {
        collectionChildrenShouldMatchCondition(searchResults(), MATCHED_RESULT_LOCATION_ICON, size(1));
    }

    private void collectionChildrenShouldMatchCondition(
            ElementsCollection collection,
            By childSelector,
            CollectionCondition condition) {
        collection.stream().forEach(e -> e.findAll(childSelector).shouldHave(condition));
    }
}
