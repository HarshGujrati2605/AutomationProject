package runner;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(plugin = { "pretty", "html:target/cucumber/report.html", "summary",
		"me.jvt.cucumber.report.PrettyReports:target/report/cucumber-html-reports",
	  }, features = { "@target/failedrun.txt" }, glue = {
				"com.stepdef" }, snippets = CAMELCASE, dryRun = false, monochrome = true)
public class FailRunner {

}
