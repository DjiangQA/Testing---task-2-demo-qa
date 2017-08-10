package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cursor {
	
	private final String boxL = "//*[@id=\"drag\"]/p";
	private final String boxM = "//*[@id=\"drag2\"]/p";
	private final String boxR = "//*[@id=\"drag3\"]/p";
	
	@FindBy (xpath = boxL)
	public WebElement BoxL;
	
	@FindBy (xpath = boxM)
	public WebElement BoxM;
	
	@FindBy (xpath = boxR)
	public WebElement BoxR;
	
	int BoxLX = 302;
	int BoxLY = 387;
	
	int BoxMX = 415;
	int BoxMY = 380;
	
	int BoxRX = 525;
	int BoxRY = 386;

}
