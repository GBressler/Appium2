package gb.Appium2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		//Start server
		service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\greg_\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:ignoreHiddenApiPolicyError", true);
		options.setCapability("appium:adbExecTimeout", 60000);
		options.setDeviceName("Pixel-8-Pro");
		options.setApp("C:\\Users\\greg_\\eclipse-workspace\\Appium2\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		
		AppiumDriverLocalService service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\greg_\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "duration",2000));
	}
	
	//no prior idea of where to scroll
	//for Pixel 8 Pro
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
		    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
		        "mobile: scrollGesture",
		        ImmutableMap.of(
		            "left", 0,
		            "top", 400,       // below typical Android status bar + app header (~150-300dp)
		            "width", 412,     // full logical width of Pixel 8 Pro
		            "height", 600,    // scrollable region height in dp
		            "direction", "down",
		            "percent", 0.75   // scroll 75% of the defined height per swipe
		        )
		    );
		} while (canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) {
		driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		            "elementId", ((RemoteWebElement)ele).getId(),
		            "direction", direction,
		            "percent", 0.3   // scroll 75% of the defined height per swipe
		        )
		    );
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
