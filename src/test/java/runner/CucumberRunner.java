package runner;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:target/prettyReport",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "timeline:target/timelineReport"
        },
        glue = { "cucumber.glue.hooks", "cucumber.glue.steps", "cucumber.glue.pages" },
        strict = true)
@ExtendWith({ TextReportExtension.class })
public class CucumberRunner { }
