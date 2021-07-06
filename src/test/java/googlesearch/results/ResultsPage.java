package googlesearch.results;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultsPage {

    public static final Target RESULT_STATS =  Target.the("Result Stats")
            .located(By.id("result-stats"));
    public static final Target TOOLS =  Target.the("Tools")
            .located(By.id("hdtb-tls"));
}