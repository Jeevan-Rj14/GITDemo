
package PageObjects;

import org.openqa.selenium.By;

import Utilies.testContextContainer;

public class HomePagePO {
	testContextContainer TestContextContainer;
	public HomePagePO(testContextContainer TestContextContainer)
	{
		this.TestContextContainer= TestContextContainer;
	}
 private By search=By.xpath("//input[@type='search']");
 private By productName=By.xpath("//h4[@class='product-name']");
 
 public void searchItems(String shortName) throws InterruptedException
 {
	 TestContextContainer.driver.findElement(search).sendKeys(shortName);
		Thread.sleep(2000);
		
	 
 }
 
 public void findProductFromList()
 {
	 String prodName1=TestContextContainer.driver.findElement(productName).getText();
	TestContextContainer.prodName=prodName1.split("-")[0].trim(); 
 }
}
