package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Events {
	
	final String events = "//*[@id=\"dragevent\"]/p";
	
	@FindBy (xpath = events)
	public WebElement Events;

}
