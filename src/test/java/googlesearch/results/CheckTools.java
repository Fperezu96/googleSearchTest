package googlesearch.results;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static googlesearch.results.ResultsPage.TOOLS;

public class CheckTools {
    public static Question<Boolean> isVisible() {
       return Question.about("Tools visibility").answeredBy(actor -> TOOLS.resolveFor(actor).isVisible());
    }
}
