package co.com.choucair.certification.seleccion.tasks;

import co.com.choucair.certification.seleccion.model.Datos;
import co.com.choucair.certification.seleccion.userinterface.UltimaPag;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static co.com.choucair.certification.seleccion.userinterface.UltimaPag.*;

public class LlevarFinal implements Task {
    private List<Datos> datos;

    public LlevarFinal(List<Datos> datos) {
        this.datos = datos;
    }

    public static LlevarFinal laPagina(List<Datos> datos) {
        return Tasks.instrumented(LlevarFinal.class, datos);
    }

    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(datos.get(0).getStrContrasena()).into(UltimaPag.CONTRASENA),
                Enter.theValue(datos.get(0).getStrApellido()).into(CONFIRMA_CONTRASENA),
                Click.on(CHECK1),
                Click.on(CHECK2),
                Click.on(CHECK3),
                Click.on(FINAL));

    }
}
