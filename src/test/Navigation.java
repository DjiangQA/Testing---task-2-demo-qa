package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation {
	
	final String draggableX = "//*[@id=\"menu-item-140\"]/a";
	
	final String cursorStyle = "//*[@id=\"ui-id-3\"]";
	
	final String events = "//*[@id=\"ui-id-4\"]";
	
	final String draggableSortable = "//*[@id=\"ui-id-5\"]";
	
	
	@FindBy (xpath = draggableX)
	public WebElement Draggable;
	
	@FindBy (xpath = cursorStyle)
	public WebElement CursorStyle;
	
	@FindBy (xpath = events)
	public WebElement Events;
	
	@FindBy (xpath = draggableSortable)
	public WebElement DraggableSortable;

}
