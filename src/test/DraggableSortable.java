package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggableSortable {

	final String draggableSortable = "//*[@id=\"draggablebox\"]";

	@FindBy(xpath = draggableSortable)
	public WebElement DraggableSortable;

}
