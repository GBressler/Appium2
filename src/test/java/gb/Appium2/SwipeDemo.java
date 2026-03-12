package gb.Appium2;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;
//import org.openqa.selenium.WebElement;

public class SwipeDemo extends BaseTest {
	@Test
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "true");
		
		//Swipe
		swipeAction(firstImage, "left");		
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[2]")).getAttribute("focusable"), "true");
		//Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
	}
}
