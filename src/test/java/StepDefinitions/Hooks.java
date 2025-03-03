package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utilies.testContextContainer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	testContextContainer TestContextContainer;
	   public Hooks(testContextContainer TestContextContainer)
	   {
		   this.TestContextContainer=TestContextContainer;
	   }

	@After("@tag1")
	public void afterScenario()
	{
		TestContextContainer.driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		//Apache commom IOs
		
		if(scenario.isFailed())
		{
		File sourcePath=((TakesScreenshot)TestContextContainer.driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		}
	}
}
