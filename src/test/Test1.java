package test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Test1 {

	private WebDriver CMDR;
	private Navigation N;
	private Draggable D;
	
	Actions actions;

	@BeforeClass
	public static void beforesetup() {

	}

	@Before
	public void setUp() {
		CMDR = new ChromeDriver();
		actions = new Actions(CMDR);
		CMDR.manage().window().maximize();
		
		N = PageFactory.initElements(CMDR, Navigation.class);
		D = PageFactory.initElements(CMDR, Draggable.class);
	}

	@Test
	public void test() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		
		String targetWebsite = "http://demoqa.com/";
		CMDR.navigate().to(targetWebsite);
		
		actions.moveByOffset(1433, 389).click().perform();
		
		wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(D.draggable));
			}
		});
		
		actions.moveByOffset(688, 413).clickAndHold().perform();
		actions.moveByOffset(1127, 643).release().perform();
		
		Thread.sleep(3000);
		
		
		

	}

	@After
	public void after() {
		CMDR.quit();
	}

	@AfterClass
	public static void afterclass() {

	}

}
