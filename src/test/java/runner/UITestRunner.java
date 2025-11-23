package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //console renkli yazdirmak icin
                "html:src/test/resources/features/htmlReport/cucumberHooks.html", //html report için
                "json:target/json-reports/cucumber.json",  //plugin ekledikten sonra bunu cucumber report için ekle
                "junit:test-output/htmlReport/cucumber.xml", //xml report için
                "rerun:TestOutput/failed_scenario.txt",//bu satirdaki kod, hata veren testleri kaydedip yeniden otomatik kosmak icin
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},//spark report icin
        //  monochrome = true, //console okunakli hale getirir, renksiz yapar
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "runner"},

        tags = "@signandlogin or @Payment",
        dryRun = false,
        monochrome = false //console okunakli hale getirir,false scenario adimlarini renkli gosterir,  true renksiz yapar
)

/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root), Hooks class yolunu ver
tags ====> çalıştırmak istediğin grubu yaz
dryRun = true ====> eksik step definition bulup gösterir. calismaz. konsolda eksik stepleri gosterir.
 */

public class UITestRunner {
}