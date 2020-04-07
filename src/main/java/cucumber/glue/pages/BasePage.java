package cucumber.glue.pages;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    public String getUrl() {
        return url();
    }
}
