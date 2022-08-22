package co.com.choucair.certification.seleccion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWhithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWhithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/choucair_reg_usuario.feature",
        tags = "@stories",
        glue= "co.com.choucair.certification.seleccion.stepdefinitions",
        snippets= SnippetType.CAMELCASE )

public class RunnerTags {
}
