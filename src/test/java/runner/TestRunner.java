package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // مكان جميع ملفات الـ feature
        glue = {"steps"}, // مكان Step Definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // تقارير
        monochrome = true // لتسهيل القراءة في الكونسول
)
public class TestRunner {
}
