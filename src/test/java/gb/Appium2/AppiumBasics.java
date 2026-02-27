package gb.Appium2;
import java.net.MalformedURLException;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName() throws MalformedURLException
	{
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//tearDown();
	}
}
