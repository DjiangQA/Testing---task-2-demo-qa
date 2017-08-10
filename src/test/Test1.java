package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {

	private WebDriver CMDR;
	private Navigation N;
	private Draggable D;
	private Constrain C;
	private Cursor Cs;
	private Events E;
	private DraggableSortable Ds;

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
	}

	@Test
	public void test() throws InterruptedException {

		int origin_posi_dragableBoxX = 688;
		int origin_posi_dragableBoxY = 413;

		int drag_posiX = 50;
		int drag_posiY = 80;

		int constrainMovementX = 454;
		int constrainMovementY = 384;

		int coursorStypeX = 450;
		int coursorStypeY = 421;

		int eventX = 406;
		int eventY = 464;

		int draggableSX = 440;
		int draggableSY = 500;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		String targetWebsite = "http://demoqa.com/";
		CMDR.navigate().to(targetWebsite);
		System.out.println("1. X:"+defMousePosiX+" Y:"+defMousePosiY);

		actions.moveByOffset(1433, 389).click().perform();

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(D.draggable));
			}
		});
		// ---------------------------------------------------------Default
		// functionality
		Point startPosi = D.Draggable.getLocation();
		actions.moveByOffset(origin_posi_dragableBoxX, origin_posi_dragableBoxY).clickAndHold(D.Draggable);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		Point endPosi = D.Draggable.getLocation();
		defMousePosiX = 0 - (origin_posi_dragableBoxX + drag_posiX);
		defMousePosiY = 0 - (origin_posi_dragableBoxY + drag_posiY);
		System.out.println("2. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		

		Thread.sleep(2000);

		// ---------------------------------------------------------Constrain
		// movement

		actions.moveByOffset(constrainMovementX, constrainMovementY).click().perform();
		defMousePosiX = 0 - constrainMovementX;
		defMousePosiY = 0 - constrainMovementY;
		System.out.println("3. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		actions.moveByOffset(C.BTLX,C.BTLY).clickAndHold(C.BTL);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BTLX + drag_posiX;
		defMousePosiY = 0 - C.BTLY + drag_posiY;
		System.out.println("4. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		actions.moveByOffset(C.BTRX,C.BTRY).clickAndHold(C.BTR);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BTRX + drag_posiX;
		defMousePosiY = 0 - C.BTRY + drag_posiY;
		System.out.println("5. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		actions.moveByOffset(C.BBLX,C.BBLY).clickAndHold(C.BBL);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BBLX + drag_posiX;
		defMousePosiY = 0 - C.BBLY + drag_posiY;
		System.out.println("6. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		actions.moveByOffset(C.BBRX,C.BBRY).clickAndHold(C.BBR);
		actions.moveByOffset(drag_posiX, drag_posiY).release().perform();
		defMousePosiX = 0 - C.BBRX + drag_posiX;
		defMousePosiY = 0 - C.BBRY + drag_posiY;
		System.out.println("7. X:"+defMousePosiX+" Y:"+defMousePosiY);
		mouseReset();
		
		Thread.sleep(2000);

		// --------------------------------------------------------- CursorStyle
		actions.click(N.CursorStyle).perform();
		
		actions.dragAndDropBy(Cs.BoxL, drag_posiX, drag_posiY);
		actions.dragAndDropBy(Cs.BoxM, drag_posiX, drag_posiY);
		actions.dragAndDropBy(Cs.BoxR, drag_posiX, drag_posiY);
		actions.perform();
		
		Thread.sleep(2000);

		// --------------------------------------------------------- Events
		actions.click(N.Events).perform();
		
		actions.dragAndDropBy(E.Events, drag_posiX, drag_posiY);
		actions.perform();

		Thread.sleep(2000);
		// --------------------------------------------------------- DraggableSortable
		actions.click(N.DraggableSortable).perform();
		
		actions.dragAndDropBy(Ds.DraggableSortable, 0, drag_posiY);
		actions.perform();
		
		Thread.sleep(2000);
	}

	public void mouseReset() {
		System.out.println("reset cal X:"+defMousePosiX+" Y:"+defMousePosiY);
		actions.moveByOffset(defMousePosiX, defMousePosiY).perform();
	}

	public void startAndEndPosiRest() {
		Point startPosi = null;
		Point endPosi = null;
	}

	@After
	public void after() {
		System.out.println(test.getStatus());
		CMDR.quit();
		report.flush();
	}

	@AfterClass
	public static void afterclass() {

	}

}
