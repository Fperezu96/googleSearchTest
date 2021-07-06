package googlesearch.results;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static googlesearch.results.ResultsPage.RESULT_STATS;

public class CheckTime {
    public static Question<String> inSeconds() {
        return Question.about("Searching time in seconds").answeredBy(actor ->
               Text.of(RESULT_STATS).viewedBy(actor)
                        .asString().substring(
                                Text.of(RESULT_STATS).viewedBy(actor).asString().indexOf("(")+1,
                                Text.of(RESULT_STATS).viewedBy(actor).asString().indexOf("(")+5));
    }
}
