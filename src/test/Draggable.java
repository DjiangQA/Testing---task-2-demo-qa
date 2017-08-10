package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable {
	
	final String draggable = "//*[@id=\"draggable\"]";
	
	@FindBy (xpath = draggable)
	public WebElement Draggable;
	
	

}