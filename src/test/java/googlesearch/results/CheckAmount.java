package googlesearch.results;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static googlesearch.results.ResultsPage.RESULT_STATS;

public class CheckAmount {
    private static String n="";

    public static Question<String> ofSearchs() {
        return Question.about("Searching amount of results").answeredBy(actor ->
                Text.of(RESULT_STATS).viewedBy(actor)
                        .asString().substring(0,
                                Text.of(RESULT_STATS).viewedBy(actor).asString().indexOf("(")+1)
                        .replaceAll("[^0-9]", ""));
    }
}
