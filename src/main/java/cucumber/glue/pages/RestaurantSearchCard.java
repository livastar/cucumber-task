package cucumber.glue.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestaurantSearchCard {

    private SelenideElement parentElement;
    private By elementSelector;

    public RestaurantSearchCard(By selector) {
        elementSelector = selector;
        parentElement = $(elementSelector);
    }

    public ElementsCollection toList() {
        return $$(elementSelector);
    }

    public SelenideElement phoneNumber = parentElement.find(".store-phone-group > div");
    public SelenideElement restaurantName = parentElement.find(".store-meta > span");
}
