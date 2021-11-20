package com.mindtree.Runner;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.PageObjects.HomeDecorPage;
import com.mindtree.PageObjects.HomePage;
import com.mindtree.PageObjects.corpGiftspage;
import com.mindtree.PageObjects.personalGiftPage;
import com.mindtree.PageObjects.top50Page;
import com.mindtree.ReusableComponents.WebDriverHelper;

public class hybridRunner extends WebDriverHelper {
	private static Logger log =LogManager.getLogger(hybridRunner.class.getName());

	@BeforeMethod
	public void getdriver() throws IOException {

		driver = initializedriver();
		
		driver.manage().window().maximize();
		log.info("driver intialised");
		driver.get(prop.getProperty("url"));
		log.info("URL HomePage opened");
	}

	@Test
	public void signIn() {

		HomePage h = new HomePage(driver);
		h.clickloginbtn().click();
		h.clickemail().sendKeys("kskr@gmail.com");
		h.clickpass().sendKeys("12345456");
		log.info("checked login");
		h.clickloginbtn().click();
	}

	@Test
	public void countlinks() {

		HomePage h = new HomePage(driver);
		log.info("geting total links on HomePage");
		System.out.println(h.getlinks());
	}

	@Test
	public void faceMasks() throws InterruptedException {
		HomePage l = new HomePage(driver);
		
		/*WebElement w = h.hovershopbycat();
        Actions action = new Actions(driver);
        action.moveToElement(w);
        Thread.sleep(2000L);
        
        WebElement sub=h.clickFaceMask();
       log.info("hovering action");
		// To mouseover on sub
		Actions actions = new Actions(driver);
		actions.moveToElement(sub);
    	actions.click().build().perform();
    	Thread.sleep(2000L);
    	h.clickMask();*/
		
		
		Actions action = new Actions(driver);
		action.moveToElement(l.hovershopbycat()).perform();
		l.clickFaceMask().click();
		System.out.println("www");
		l.clickMask().click();
		System.out.println("qqq");
		//Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Harry Potter Always Cotton Mask With']")), "Harry Potter Always Cotton Mask With");

	}

	@Test
	public void getTop50() {
		HomePage h = new HomePage(driver);
		h.clickTop50().click();
		top50Page t = new top50Page(driver);
		t.clicksortbtn().click();
		t.clickbestSelling().click();
		t.clickreqprod().click();

	}

	@Test
	public void getCorpGift() {
		HomePage h = new HomePage(driver);
		h.clickCorpgift().click();
		corpGiftspage c = new corpGiftspage(driver);
		c.clickName().sendKeys("Sidha");
		c.clickEmail().sendKeys("sidda@gmail.com");
		c.clickNum().sendKeys("9182874107");
		c.clickSubmit().click();

	}

	
	@Test
	public void getPersonalGift() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickPersonalGift().click();
		personalGiftPage p = new personalGiftPage(driver);
		p.clickprod().click();
		
		p.clickAddWish().click();
		
		//Assert.assertTrue(driver.findElement(By.className("swym-link")).isDisplayed());
	}

	
	@Test
	public void getprodBysearch() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickSearchBox().sendKeys("Spider Man");
		
		h.clickSearchBox().sendKeys(Keys.ENTER);
		
		personalGiftPage p = new personalGiftPage(driver);
		p.clickSpidermanprod().click();
		
		p.clickAddToCartSpd().click();
	
		p.clickCheckOut().click();

	}

	@Test
	public void checkCashOnDeliveryAvail() {
		HomePage h = new HomePage(driver);
		h.clickHomeDecor().click();
		HomeDecorPage hh = new HomeDecorPage(driver);
		hh.clickBulb().click();
		hh.clickpincodeBox().sendKeys("516172");
		hh.clickCheck().click();

	}
	@Test
	public void getViewAll() {
		HomePage h = new HomePage(driver);
		h.clickViewAll().click();
		HomeDecorPage hh = new HomeDecorPage(driver);
		hh.clickWoodenProd().click();
		hh.clickSize().click();
		hh.clickquantity().click();
		hh.clickAddCart().click();
	}
	
	
	@Test
	public void getGiftCard() {
		HomePage h = new HomePage(driver);
		h.clickGiftCard().click();
		top50Page t = new top50Page(driver);
		t.clickthousand().click();
		t.clickWishlist().click();
		
	}

	@AfterMethod
	public void closeDriver() {

		driver.quit();
	}

}
