package co.com.choucair.certification.seleccion.stepdefinitions;

import co.com.choucair.certification.seleccion.model.Datos;
import co.com.choucair.certification.seleccion.tasks.LlenarDireccion;
import co.com.choucair.certification.seleccion.tasks.LlenarDispositivos;
import co.com.choucair.certification.seleccion.tasks.LlenarFormularioDatos;
import co.com.choucair.certification.seleccion.tasks.LlevarFinal;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Responder;
import tasks.AbrirPlataforma;

import java.util.List;


public class ChoucairUTestStepDefinitions {

    @Before
    public void  setStager(){
        OnStage.setTheStage((new OnlineCast()));
    }
    @Given("^Daniela desea registrarse en la plataforma Utest$")
    public void danielaDeseaRegistraseEnLaPlataformaDeUtest() throws Exception{
        OnStage.theActorCalled("Daniela").wasAbleTo(AbrirPlataforma.laPagina());
    }
    @When("^El usuario ingresa toda la informacioon requerida por la pagina$")
    public void elUsuarioIngresaTodaLaInformacioonRequeridaPorLaPagina(List<Datos> datos) throws Exception{
        OnStage.theActorInTheSpotlight().attemptsTo(LlenarFormularioDatos.laPagina(datos), LlenarDireccion.laPagina(datos),
        LlenarDispositivos.laPagina(datos), LlevarFinal.laPagina(datos)
        );
    }

    @Then("^el registro se completa cuando aparece el Boton Complete Setup$")
    public void ElRegistroSeCompletaCuandoApareceElBotonCompleteSetup(List<Datos> datos) throws Exception{
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Responder.a(datos)));
    }

}
