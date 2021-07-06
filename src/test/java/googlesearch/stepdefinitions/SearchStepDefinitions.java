package googlesearch.stepdefinitions;

import googlesearch.results.CheckAmount;
import googlesearch.results.CheckTime;
import googlesearch.results.CheckTools;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import googlesearch.navigation.NavigateTo;
import googlesearch.search.LookForInformation;

public class SearchStepDefinitions {

    private static String actorName = "Felipe";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^is researching things on the internet$")
    public void researchingThings() {
        OnStage.theActorCalled(actorName).wasAbleTo(NavigateTo.googleHomePage());
    }

    @When("^looks up (.*)$")
    public void searchesFor(String term) {
        OnStage.theActorCalled(actorName).attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("^should see information about$")
    public void should_see_information_about() {
        OnStage.theActorCalled(actorName).attemptsTo(
                Ensure.thatTheAnswerTo("Is Tools visible?",
                        CheckTools.isVisible()).isTrue());
        OnStage.theActorCalled(actorName).attemptsTo(
                Ensure.thatTheAnswerTo("Is time in seconds?",
                        CheckTime.inSeconds()).asADouble().isCloseTo(0.0,1.0));
        OnStage.theActorCalled(actorName).attemptsTo(
                Ensure.thatTheAnswerTo("Amount of searching results?",
                        CheckAmount.ofSearchs()).asAnInteger().isGreaterThan(1));
    }
}
