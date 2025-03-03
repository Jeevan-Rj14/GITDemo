package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import Utilies.testContextContainer;

public class DealsPagePO {
	
	testContextContainer TestContextContainer;

	public DealsPagePO(testContextContainer TestContextContainer) {
		this.TestContextContainer = TestContextContainer;
	}

	private By search = By.xpath("//input[@id='search-field']");
	private By productName = By.xpath("//td[1]");

	public void searchOffer(String shortName) throws InterruptedException {
		TestContextContainer.driver.findElement(search).sendKeys(shortName);
		Thread.sleep(2000);

	}

	public String getProduct() {
		TestContextContainer.prodNameDeal=TestContextContainer.driver.findElement(productName).getText().trim();

		return TestContextContainer.prodNameDeal;

	}

	public void switchToDealsPage() {
		TestContextContainer.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> iterator = TestContextContainer.driver.getWindowHandles();
		Iterator<String> it = iterator.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		TestContextContainer.driver.switchTo().window(childWindow);
	}

}
