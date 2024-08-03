package runner;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/report.html", "summary",
		"me.jvt.cucumber.report.PrettyReports:target/report/cucumber-html-reports", "rerun:target/failedrun.txt",
		"json:target/cucumber-report-json/Cucumber.json" }, features = { "src/test/resources" }, glue = {
				"com.stepdef" }, snippets = CAMELCASE, dryRun = false, monochrome = true, tags = "@regression")
public class CucumberRunnerTest {
	
	@AfterClass
	public static void teardown() {
		
		File outputdirec = new File("target/report/cucumber-html-reports");
		List json = new ArrayList<>();
		json.add("target/cucumber-report-json/Cucumber.json");
		Configuration configuration = new Configuration(outputdirec, "SolJamaicaWebAutomation");
		ReportBuilder build  = new ReportBuilder(json, configuration);
		build.generateReports();
		
		
	}

}
