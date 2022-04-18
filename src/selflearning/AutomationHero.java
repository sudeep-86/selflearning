package selflearning;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationHero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// hello world

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		// implicitwait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// explicitwait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//xpath")));

		// code to handle 3rd child window
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i = s1.iterator();
		String child1 = i.next();
		String child2 = i.next();

		// How to handle https certifications
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// WebDriver driver = new ChromeDriver(cap);

		// How to enter text in caps
		driver.findElement(By.xpath("//path")).sendKeys(Keys.SHIFT, "hello");

		// How to mouse over on the web element on page
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//path"))).build().perform();

		// Handle alerts in java
		driver.switchTo().alert().accept();// dismiss();

		// How to get link count in page
		int linkcount = driver.findElements(By.tagName("a")).size();

		// Xpath to handle parent from child
		// tagname[@id='value']/parent::parenttagname

		// Take screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/selenium/error.png"));

		// Hit Enter from WebDriver command
		driver.findElement(By.xpath("//path")).sendKeys(Keys.ENTER);

		// Code to handle calender
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'][class='datepicker-switch']")).getText()
				.contains("December")) {
			driver.findElement(By.cssSelector("[class=datepicker-days][class-next]")).click();
		}
		List<WebElement> dates = driver.findElements(By.cssSelector("[class='datepicker-days'][class='day']"));
		int count = driver.findElements(By.cssSelector("[class='datepicker-days'][class='day']")).size();
		for (int i1 = 0; i1 < count; i1++) {
			String text = driver.findElements(By.cssSelector("[class='datepicker-days'][class='day']")).get(i1)
					.getText();
			if (text.equalsIgnoreCase("30")) {
				driver.findElements(By.cssSelector("[class='datepicker-days][class='day']")).get(i1).click();
				break;
			}

		}

	}

}
