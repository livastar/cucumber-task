package cucumber.glue.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SearchPage {

    private static final By BLACK_SEED_HEADER_LOGO = By.cssSelector("header img[src*='Black_Seed']");
    private static final By SEARCH_FIELD = By.cssSelector("#searchBox");
    private static final By SEARCH_RESULTS = By.cssSelector(".pac-container > .pac-item");
    private static final By MATCHED_RESULTS = By.cssSelector(".pac-item-query > .pac-matched");
    private static final By MATCHED_RESULT_LOCATION_ICON = By.cssSelector(".pac-icon");

    public SearchPage open() {
        Selenide.open("/locations/blackseedbagels");
        return new SearchPage();
    }

    public String getUrl() {
        return url();
    }

    public SelenideElement shouldSeeTheLogo() {
        return $(BLACK_SEED_HEADER_LOGO).should(Condition.appear);
    }

    public SelenideElement enterValueInASearchField(String text) {
        return $(SEARCH_FIELD).setValue(text);
    }

    public List<SelenideElement> searchResults() {
        return $$(SEARCH_RESULTS);
    }

    public void shouldSeeMatchedSearchResults() {
        searchResults().stream()
                .forEach(e -> e.findAll(MATCHED_RESULTS)
                        .shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1)));
    }

    public void shouldSeeSearchResultsLocationIcons() {
        searchResults().stream()
                .forEach(e -> e.findAll(MATCHED_RESULT_LOCATION_ICON)
                        .shouldBe(CollectionCondition.size(1)));
    }
}
