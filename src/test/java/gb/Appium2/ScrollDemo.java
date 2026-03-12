package gb.Appium2;

import java.net.MalformedURLException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		
		//if you know where to scroll TO
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
//		
		
		
		//for Pixel 8 Pro
		scrollToEndAction();
		
		
		Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("WebView")).isDisplayed());
	}
	

}
