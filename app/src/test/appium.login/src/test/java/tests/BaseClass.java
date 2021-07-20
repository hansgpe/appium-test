package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		DesiredCapabilities caps = new DesiredCapabilities();
		try {
			

			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86_arm");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability("appPackage", "com.android.calculator2");
			caps.setCapability("appActivity", "com.android.calculator2.Calculator");
			


			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void checkUserNames() {
		
		driver.findElement(By.name("2")).click();
//		driver.findElement(By.id("username")).click();
//		driver.findElement(By.id("username")).sendKeys("user@domain.com");

	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
}
