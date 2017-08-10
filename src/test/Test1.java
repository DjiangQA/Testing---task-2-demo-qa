package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.firefox.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {

	private WebDriver CMDR;
	private WebDriver FDDR;
	
	private Navigation N;
	private Draggable D;
	private Constrain C;
	private Cursor Cs;
	private Events E;
	private DraggableSortable Ds;
	private Menue M;

	Actions actions;

	int defMousePosiX = 0;
	int defMousePosiY = 0;

	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFilePath = "Report.html";

	@BeforeClass
	public static void beforesetup() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("Test1_report");
		extentHtmlReporter.config().setDocumentTitle("Test1_report");
		report.attachReporter(extentHtmlReporter);
		test = report.createTest("Test1");
	}

	@Before
	public void setUp() {
		CMDR = new ChromeDriver();
		actions = new Actions(CMDR);
		CMDR.manage().window().maximize();

		N = PageFactory.initElements(CMDR, Navigation.class);
		D = PageFactory.initElements(CMDR, Draggable.class);
		C = PageFactory.initElements(CMDR, Constrain.class);
		Cs = PageFactory.initElements(CMDR, Cursor.class);
		E = PageFactory.initElements(CMDR, Events.class);
		Ds = PageFactory.initElements(CMDR, DraggableSortable.class);
		M = PageFactory.initElements(CMDR, Menue.class);
	}

	@Test
	public void test_chrome() throws InterruptedException, IOException {

		int origin_posi_dragableBoxX = 688;
		int origin_posi_dragableBoxY = 413;
		
		int drag_posiX = 50;
		int drag_posiY = 80;

		int constrainMovementX = 454;
		int constrainMovementY = 384;

		//int coursorStypeX = 450;
		//int coursorStypeY = 421;

		//int eventX = 406;
		//int eventY = 464;

		//int draggableSX = 440;
		//int draggableSY = 500;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		String targetWebsite = "http://demoqa.com/";
		test.info("Test website:"+ targetWebsite);
		
		CMDR.navigate().to(targetWebsite);
		System.out.println("1. X:"+defMousePosiX+" Y:"+defMousePosiY);

		actions.moveByOffset(1433, 389).click().perform();

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(D.draggable));
			}
		});
		// ---------------------------------------------------------Defaultfunctionality
		test.info("Start test on Draggable");
		Point startPosi = D.Draggable.getLocation();
		test.info("Clicked on Draggable");
		actions.moveByOffset(origin_posi_dragableBoxX, origin_posi_dragableBoxY).clickAndHold(D.Draggable);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		Point endPosi = D.Draggable.getLocation();
		defMousePosiX = 0 - (origin_posi_dragableBoxX + drag_posiX);
		defMousePosiY = 0 - (origin_posi_dragableBoxY + drag_posiY);
		System.out.println("2. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		assertNotEquals("Web element Draggable didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element Draggable didn't move, test failed");
			
		}
		else
			test.pass("Web element Draggable moved, test passed");
		
		test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Draggable end of test")));

		//Thread.sleep(2000);
		test.info("Finish test on Draggable");
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(C.boxTopLeft));
			}
		});

		// ---------------------------------------------------------Constrainmovement
		test.info("Start test on Constrain movement");
		actions.moveByOffset(constrainMovementX, constrainMovementY).click().perform();
		defMousePosiX = 0 - constrainMovementX;
		defMousePosiY = 0 - constrainMovementY;
		System.out.println("3. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		startPosi = C.BTL.getLocation();
		actions.moveByOffset(C.BTLX,C.BTLY).clickAndHold(C.BTL);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BTLX + drag_posiX;
		defMousePosiY = 0 - C.BTLY + drag_posiY;
		System.out.println("4. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		endPosi = C.BTL.getLocation();
		
		assertNotEquals("Web element BTL didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BTL didn't move, test failed");
		}
		else
			test.pass("Web element BTL moved, test passed");
		
		
		startPosi = C.BTR.getLocation();
		actions.moveByOffset(C.BTRX,C.BTRY).clickAndHold(C.BTR);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BTRX + drag_posiX;
		defMousePosiY = 0 - C.BTRY + drag_posiY;
		System.out.println("5. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		endPosi = C.BTR.getLocation();
		
		assertNotEquals("Web element BTR didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BTR didn't move, test failed");
		}
		else
			test.pass("Web element BTR moved, test passed");
		
		
		startPosi = C.BBL.getLocation();
		actions.moveByOffset(C.BBLX,C.BBLY).clickAndHold(C.BBL);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BBLX + drag_posiX;
		defMousePosiY = 0 - C.BBLY + drag_posiY;
		System.out.println("6. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		endPosi = C.BBL.getLocation();
		
		assertNotEquals("Web element BBL didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BBL didn't move, test failed");
		}
		else
			test.pass("Web element BBL moved, test passed");
		
		startPosi = C.BBR.getLocation();
		actions.moveByOffset(C.BBRX,C.BBRY).clickAndHold(C.BBR);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BBRX + drag_posiX;
		defMousePosiY = 0 - C.BBRY + drag_posiY;
		System.out.println("7. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		endPosi = C.BBR.getLocation();
		
		assertNotEquals("Web element BBR didn't move, test failed",startPosi, endPosi );
		 
		if ( startPosi == endPosi )
		{
			test.fail("Web element BBR didn't move, test failed");
		}
		else
			test.pass("Web element BBR moved, test passed");
		
		test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Constrain movement end of test")));
		
		test.info("Finish test on Constrain movement");
		//Thread.sleep(2000);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(Cs.boxL));
			}
		});

		// --------------------------------------------------------- CursorStyle
		test.info("Start test on CursorStyle");
		actions.click(N.CursorStyle).perform();
		
		startPosi = Cs.BoxL.getLocation();
		actions.dragAndDropBy(Cs.BoxL, drag_posiX, drag_posiY).perform();
		endPosi = Cs.BoxL.getLocation();
		
		assertNotEquals("Web element BoxL didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BoxL didn't move, test failed");
		}
		else
			test.pass("Web element BoxL moved, test passed");
		
		startPosi = Cs.BoxM.getLocation();
		actions.dragAndDropBy(Cs.BoxM, drag_posiX, drag_posiY).perform();
		endPosi = Cs.BoxM.getLocation();
		
		assertNotEquals("Web element BoxM didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BoxM didn't move, test failed");
		}
		else
			test.pass("Web element BoxM moved, test passed");
		
		startPosi = Cs.BoxR.getLocation();
		actions.dragAndDropBy(Cs.BoxR, drag_posiX, drag_posiY).perform();
		endPosi = Cs.BoxR.getLocation();
		
		assertNotEquals("Web element BoxR didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element BoxR didn't move, test failed");
		}
		else
			test.pass("Web element BoxR moved, test passed");
		
		test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Cursor Style end of test")));
		
		test.info("Finish test on Cursor Style");
		//Thread.sleep(2000);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(E.events));
			}
		});

		// --------------------------------------------------------- Events
		test.info("Start test on Events");
		actions.click(N.Events).perform();
		
		startPosi = E.Events.getLocation();
		actions.dragAndDropBy(E.Events, drag_posiX, drag_posiY);
		actions.perform();
		endPosi = E.Events.getLocation();
		
		assertNotEquals("Web element Events didn't move, test failed",startPosi, endPosi );
		
		if ( startPosi == endPosi )
		{
			test.fail("Web element Events didn't move, test failed");
		}
		else
			test.pass("Web element Events moved, test passed");
		test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Events end of test")));
		test.info("Finish test on Events");
		//Thread.sleep(2000);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.draggableSortable));
			}
		});
		// --------------------------------------------------------- DraggableSortable
		test.info("Start test on DraggableSortable");
		actions.click(N.DraggableSortable).perform();
		
		actions.dragAndDropBy(Ds.DraggableSortable, 0, drag_posiY);
		actions.perform();
		
		test.log(
				Status.INFO,
				"End test Snapshot : "
						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "DraggableSortable end of test")));
		
		test.info("Finish test on DraggableSortable");
		//Thread.sleep(2000);
		
		// --------------------------------------------------------- Menu
		actions.click(N.Menue).perform();
		actions.moveToElement(M.Menue).click().perform();
		actions.moveToElement(M.Menue_option1).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue_option2).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue_option3).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue_option4).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue_option5).perform();
		Thread.sleep(1000);
		
		
		actions.moveToElement(M.Menue2).click().perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue2_option1).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue2_option2).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue2_option3).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue2_option4).perform();
		Thread.sleep(1000);
		actions.moveToElement(M.Menue2_option5).perform();
		
		Thread.sleep(1000);
		
	}

	public void mouseReset() {
		System.out.println("reset cal X:"+defMousePosiX+" Y:"+defMousePosiY);
		actions.moveByOffset(defMousePosiX, defMousePosiY).perform();
	}

	@After
	public void after() {
		test.info("Test Status:"+test.getStatus());
		System.out.println(test.getStatus());
		CMDR.quit();
		report.flush();
	}

	@AfterClass
	public static void afterclass() {

	}

}
