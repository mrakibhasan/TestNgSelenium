package tutorialselenium.fileupload;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class FileUploadWindows {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		baseUrl = "https://www.gmail.com/";
		driver = new FirefoxDriver();;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void fileUpload() throws AWTException, InterruptedException {
		//driver.findElement(By.xpath("[@id='identifierLink']/div[2]/p")).click();
		driver.findElement(By.id("identifierId")).sendKeys("rakibulcse05");//email
		driver.findElement(By.xpath("//div[@id='identifierNext']/div[2]")).click();
		driver.findElement(By.xpath("//div[@id='password']//div[@class='AxOyFc snByac']")).sendKeys("Raha634709"); // Enter your password
		
		/*driver.findElement(By.xpath("//div[@id='passwordNext']//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("letskodeit@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();
		
		StringSelection ss = new StringSelection("C:\\Users\\Anil Tomar\\Desktop\\testfile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();*/
	}

	@AfterClass
	public void afterClass() {
	}

}