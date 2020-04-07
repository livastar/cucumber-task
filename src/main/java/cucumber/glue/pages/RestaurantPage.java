package cucumber.glue.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RestaurantPage extends BasePage {

    private SelenideElement locationAddress =
            $(".hero-block--description-custom > .hero-block--location:first-child");

    public SelenideElement getLocationAddress() {
        return locationAddress;
    }

    public RestaurantPage open(String restaurantNameFormatted) {
        Selenide.open(String.format("/black-seed-%s/menu", restaurantNameFormatted));
        locationAddress.shouldBe(visible);
        return new RestaurantPage();
    }
}
