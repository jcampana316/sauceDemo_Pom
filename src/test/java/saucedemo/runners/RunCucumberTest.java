package saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"saucedemo.stepdefinitions"},
        tags = "@login,@shop,@checkout",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin ={
                "pretty",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)

public class RunCucumberTest {
}
