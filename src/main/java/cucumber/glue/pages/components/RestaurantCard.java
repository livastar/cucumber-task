package cucumber.glue.pages.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class RestaurantCard {

    private SelenideElement phoneNumber = $(".store-phone-group > div");
    private SelenideElement cardName = $(".store-meta > span");
    private SelenideElement cardAddress = $(".store-meta > div");
    private SelenideElement restaurantOrderStatus = $(".store-order-now-group div:first-child > span");
    private SelenideElement restaurantOpenStatus = $(".store-order-now-group div:last-child > span");
}
