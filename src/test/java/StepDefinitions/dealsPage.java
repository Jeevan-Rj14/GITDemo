package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.DealsPagePO;
import Utilies.testContextContainer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dealsPage {
	
	//String prodNameDeal;
	testContextContainer TestContextContainer;
   public dealsPage(testContextContainer TestContextContainer)
   {
	   this.TestContextContainer=TestContextContainer;
   }
   

	@Then("^User will search for the (.+) shortname in Deal page$")
	public void user_will_search_for_the_shortname_in_deal_page(String shortName) throws InterruptedException {
		
		
		//String prodName="Tom";
		DealsPagePO dp=new  DealsPagePO(TestContextContainer);
		dp.switchToDealsPage();
		dp.searchOffer(shortName);
		TestContextContainer.prodNameDeal=dp.getProduct();
		
	}
	
	@And("Validate productname in offers page matches with Home page")
	public void Validate_productname_in_offers_page_matches_with_Home_page(){
		
		Assert.assertEquals(TestContextContainer.prodName,TestContextContainer.prodNameDeal);
		
	}

}
