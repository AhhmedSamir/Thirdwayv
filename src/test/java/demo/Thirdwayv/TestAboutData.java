package demo.Thirdwayv;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.LoadProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAboutData {


	AppiumDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName",LoadProperty.userData.getProperty("deviceName"));
		caps.setCapability("platformName",LoadProperty.userData.getProperty("platformName"));
		caps.setCapability("automationName",LoadProperty.userData.getProperty("automationName"));
		caps.setCapability("appPackage",LoadProperty.userData.getProperty("appPackage"));
		caps.setCapability("appActivity",LoadProperty.userData.getProperty("appActivity"));
		driver = new AndroidDriver(new URL ("http://localhost:4723/wd/hub"),caps);
	}
	
	@Test
	public void TestingEmulatedDeviceAboutData() {
		WebElement aboutDeviceBtn = driver.findElement(MobileBy.AndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text (\"About emulated device\"))"));
		aboutDeviceBtn.click();
		WebElement deviceName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
		deviceName.click();
		WebElement deviceNameValue= driver.findElement(By.id("android:id/edit"));
		assertEquals(deviceNameValue.getText(),LoadProperty.userData.getProperty("deviceNameValue"));
		WebElement okBtn = driver.findElement(By.id("android:id/button1"));
		okBtn.click();
		WebElement okBtn2 = driver.findElement(By.id("android:id/button1"));
		okBtn2.click();
		WebElement androidVersion= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.RelativeLayout"));
		androidVersion.click();
		WebElement androidVersionValue= driver.findElement(By.id("android:id/summary"));
		assertEquals(androidVersionValue.getText(),LoadProperty.userData.getProperty("androidDeviceValue"));
		WebElement backBtn= driver.findElement(MobileBy.AccessibilityId("Back"));
		backBtn.click();
		WebElement model = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout"));
		model.click();
		WebElement modelNumber = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]"));
		assertEquals(modelNumber.getText(), LoadProperty.userData.getProperty("modelNumber"));
		WebElement serialNumber= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]"));
		assertEquals(serialNumber.getText(), LoadProperty.userData.getProperty("serialNumber"));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
