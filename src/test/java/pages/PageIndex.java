package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageIndex {
	private WebDriver driver;
	
	public PageIndex (WebDriver driver) {
		this.driver = driver; 
	}
	public void search (String termToSearch) {
		driver.findElement(By.id("search_query_top")).sendKeys(termToSearch);
		driver.findElement(By.name("submit_search")).click();
	}

}
