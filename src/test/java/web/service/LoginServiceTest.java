package web.service;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
	private WebDriver driver;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:/Deakin/Uni/2024 Tri 1/SIT707 - Software Quality And Testing/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		driver.navigate()
				.to("file:///D:/Deakin/Uni/2024 Tri 1/SIT707 - Software Quality And Testing/OnTrack/8.1P - Pass Task - "
						+ "Integrate front and back ends 1/8.1P-resources/pages/login.html");
		// sleep(5);
	}

	@After
	public void close() {
		sleep(2);
		driver.quit();
	}

	private int getResponse(WebDriver driver) throws IOException {
		String thisUrl = driver.getCurrentUrl();

		URL url = new URL(thisUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		return connection.getResponseCode();
	}

	public void testLoginSuccess(String username, String password, String dob) {

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);

		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys(dob);
		sleep(2);
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		/*
		 * On successful login, the title of page changes to 'success', otherwise,
		 * 'fail'. String title = driver.getTitle(); System.out.println("Title: " +
		 * title); Assert.assertEquals(title, "success");
		 */

	}

	@Test
	public void testEmptyUsernameCorrectPasswdCorrectDobLoginSuccess() throws IOException {
		testLoginSuccess("", "ahsan_pass", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testNullUsernameCorrectPasswdCorrectDobLoginSuccess() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		testLoginSuccess(null, "ahsan_pass", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testWrongUsernameCorrectPasswdCorrectDobLoginSuccess() throws IOException {
		testLoginSuccess("vishuddha", "ahsan_pass", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameEmptyPasswdCorrectDobLoginSuccess() throws IOException {
		testLoginSuccess("ahsan", "", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameWrongPasswdCorrectDobLoginSuccess() throws IOException {
		testLoginSuccess("ahsan", "vishpass", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameNullPasswdCorrectDobLoginSuccess() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		testLoginSuccess("ahsan", null, "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameCorrectPasswdwEmptyDobLoginSuccess() throws IOException {
		testLoginSuccess("ahsan", "ahsan_pass", "");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameCorrectPasswdwWrongDobLoginSuccess() throws IOException {
		testLoginSuccess("ahsan", "ahsan_pass", "05/22/1990");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameCorrectPasswdwNullDobLoginSuccess() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		testLoginSuccess("ahsan", "ahsan_pass", null);
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(404, response);
	}

	@Test
	public void testCorrectUsernameCorrectPasswdCorrectDobLoginSuccess() throws IOException {
		testLoginSuccess("ahsan", "ahsan_pass", "05/22/1993");
		int response = getResponse(driver);
		System.out.println("Code - " + response);
		Assert.assertEquals(200, response);
	}

}
