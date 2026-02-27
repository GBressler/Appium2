package gb.Appium2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
