package PageObjects;

import Utilies.testContextContainer;

public class PageObjectManager {
	

	 testContextContainer TestContextContainer;
	 public HomePagePO homePagePO;
	 public DealsPagePO dealsPagePO;
	 
	 //constructor
	 
	 public PageObjectManager(testContextContainer TestContextContainer)
	 {
		this.TestContextContainer=TestContextContainer;
	 }
	
	
	public HomePagePO getHomePage()
	{
		homePagePO=new HomePagePO( TestContextContainer);
		return homePagePO;
	}
	
	public DealsPagePO getDealsPage()
	{
		dealsPagePO=new DealsPagePO( TestContextContainer);
		return dealsPagePO;
	}
	

}
