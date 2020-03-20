package newTest;

import org.junit.Rule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import io.appium.java_client.MobileElement;

import java.awt.AWTException;
import java.io.IOException;

import com.microsoft.appcenter.appium.Factory;

import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import org.junit.rules.TestWatcher;

public class nTest {
			
	private EnhancedIOSDriver<MobileElement> driver;
	
    @Rule
    public TestWatcher watcher = Factory.createWatcher();
	
//    @Before
//	public void method1() throws Exception, AWTException {
//		Putty.method1();
//		}
    
	@Before
	public void setUp() throws IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 8 Plus");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("noReset", true);
		caps.setCapability("clearSystemFiles", true);
		caps.setCapability("platformVersion", "12.4");
		caps.setCapability("connectHardwareKeyboard", false);
		caps.setCapability("autoAcceptAlerts", false);
		caps.setCapability("app", "/Users/akvesic/MARS.App.iOS.app");
		
		driver = Factory.createIOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
	}

    @After
    public void tearDown() {
        driver.label("Stopping App");
    	driver.quit();
}
    @Test
    public void Login() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	MobileElement mobileElement = (MobileElement) driver.findElementByAccessibilityId("usernameTextBox");
    	Thread.sleep(3000);
    	mobileElement.click();
    	Thread.sleep(3000);
		mobileElement.sendKeys("someone");
        driver.label("See the App");
    	Thread.sleep(3000);
    	MobileElement mobileElement3 = (MobileElement) driver.findElementByAccessibilityId("loginButton");
    	Thread.sleep(3000);
		mobileElement3.click();
    	Thread.sleep(3000);
		
	}
}