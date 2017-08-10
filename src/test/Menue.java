package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menue {



	final String menue = "//*[@id=\"ui-id-1\"]";
	final String menue_option1 = "#tabs-1> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)";
	final String menue_option2 = "#tabs-1> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)";
	final String menue_option3 = "#tabs-1> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)";
	final String menue_option4 = "#tabs-1> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)";
	final String menue_option5 = "#tabs-1> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)";
	
	final String menue2 = "//*[@id=\"ui-id-2\"]";
	final String menue2_option1 = "#tabs-2> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)";
	final String menue2_option2 = "#tabs-2> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)";
	final String menue2_option3 = "#tabs-2> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)";
	final String menue2_option4 = "#tabs-2> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)";
	final String menue2_option5 = "#tabs-2> div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)";

	@FindBy(xpath = menue)
	public WebElement Menue;
	
	@FindBy (css = menue_option1)
	public WebElement Menue_option1;
	
	@FindBy (css = menue_option2)
	public WebElement Menue_option2;
	
	@FindBy (css = menue_option3)
	public WebElement Menue_option3;
	
	@FindBy (css = menue_option4)
	public WebElement Menue_option4;
	
	@FindBy (css = menue_option5)
	public WebElement Menue_option5;
	
	@FindBy (xpath = menue2)
	public WebElement Menue2;
	
	@FindBy (css = menue2_option1)
	public WebElement Menue2_option1;
	
	@FindBy (css = menue2_option2)
	public WebElement Menue2_option2;
	
	@FindBy (css = menue2_option3)
	public WebElement Menue2_option3;
	
	@FindBy (css = menue2_option4)
	public WebElement Menue2_option4;
	
	@FindBy (css = menue2_option5)
	public WebElement Menue2_option5;
}
