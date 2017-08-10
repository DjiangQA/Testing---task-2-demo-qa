package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constrain {
	
	private final String boxTopLeft = "//*[@id=\"draggabl\"]/p";
	private final String boxTopRight = "//*[@id=\"draggabl2\"]/p";
	private final String boxbottomLeft = "//*[@id=\"draggabl3\"]/p";
	private final String boxbottomRight = "//*[@id=\"draggabl5\"]";
	
	@FindBy (xpath = boxTopLeft)
	public WebElement BTL;
	
	@FindBy (xpath = boxTopRight)
	public WebElement BTR;
	
	@FindBy (xpath = boxbottomLeft)
	public WebElement BBL;
	
	@FindBy (xpath = boxbottomRight)
	public WebElement BBR;
	
	int BTLX = 619;
	int BTLY = 438;
	
	int BTRX = 720;
	int BTRY = 437;
	
	int BBLX = 631;
	int BBLY = 600;
	
	int BBRX = 723;
	int BBRY = 593;
	

}
