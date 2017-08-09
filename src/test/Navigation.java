package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	
	final String draggableId = "menu-item-140";
	String draggableX = "//*[@id=\"menu-item-140\"]/a";
	String draggableWebsite = "http://demoqa.com/draggable/";
	
	@FindBy (xpath = "//*[@id=\"menu-item-140\"]/a")
	public WebElement Draggable;
	
	

}
