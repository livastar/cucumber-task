package cucumber.glue.pages.components;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

@Getter
public class RestaurantCardCollection extends ElementsCollection {

    private RestaurantCard restaurantCard;

    public RestaurantCardCollection(Driver driver, String cssSelector) {
        super(driver, cssSelector);
        restaurantCard = new RestaurantCard();
    }
}
