package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/report.html", "summary",
		"me.jvt.cucumber.report.PrettyReports:target/report/cucumber-html-reports"  , "rerun:target/failedrun.txt"}, features = {
				"src/test/resources" }, glue = {
						"com.stepdef" }, snippets = CAMELCASE, dryRun = false, monochrome = true, tags = "@addroadtransport"
)
public class CucumberRunnerTest {
	
}
