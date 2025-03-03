package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.HomePagePO;
import PageObjects.PageObjectManager;
import Utilies.testContextContainer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {
	
	testContextContainer TestContextContainer;
	PageObjectManager pageObjectManager;
	
	 public HomePage(testContextContainer TestContextContainer)
	   {
		 this.TestContextContainer=TestContextContainer;
	   }
	 
	 
	
	@Given("Use is on GreenCart landing page")
	public void use_is_on_green_cart_landing_page() throws IOException {
		//Properties
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\Resources\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Url=prop.getProperty("QAurl");
		
		
		TestContextContainer.driver=new ChromeDriver();
		TestContextContainer.driver.get(Url);
	        
	    
	}
	
	
	@When("^User search with shortname (.+) and extract the actual name$")
	public void user_search_with_shortname_and_extract_the_actual_name(String shortName) throws InterruptedException {
		Thread.sleep(2000);
		//HomePagePO home=new HomePagePO(TestContextContainer);
		pageObjectManager=new PageObjectManager(TestContextContainer);
		HomePagePO home=pageObjectManager.getHomePage();
		home.searchItems(shortName);
		home.findProductFromList();
		
		
		System.out.println(TestContextContainer.prodName);
	    
	}


}
