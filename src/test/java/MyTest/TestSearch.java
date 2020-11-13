package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageIndex;

public class TestSearch {
	private WebDriver driver; 
	private PageIndex pIndex; 
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		pIndex = new PageIndex (driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();	
		
	}
	 
	@Test
	public void searchDresses() {
		pIndex.search("DRESSES");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bannerText = driver.findElement(By.className("lighter")).getText();
		Assert.assertEquals("\"DRESSES\"", bannerText);
		
	}
	
	@Test
	public void searchTSHIRTS() {
		pIndex.search("T-SHIRTS");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bannerText = driver.findElement(By.className("lighter")).getText();
		Assert.assertEquals("\"T-SHIRTS\"", bannerText);

	}
	@Test
	public void NoResults() {
		pIndex.search("Hello world");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bannerText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
		Assert.assertEquals(bannerText,"No results were found for your search \"hello world\"");
		
	}
}
