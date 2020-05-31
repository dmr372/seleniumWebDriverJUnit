package org.ual.hmis.LosAngelesDeStark;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LogincorrectoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(false);
		driver = new FirefoxDriver(firefoxOptions);
		
		/**
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(false);
		driver = new ChromeDriver(chromeOptions);
		*/

	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void logincorrecto() {
    driver.get("https://webapp120200527070455.azurewebsites.net/");
    driver.manage().window().setSize(new Dimension(697, 735));
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("Input_Email")).click();
    driver.findElement(By.id("Input_Email")).sendKeys("sample3@ual.es");
    driver.findElement(By.id("Input_Password")).sendKeys("Password1_");
    driver.findElement(By.id("login-submit")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.linkText("WebApp1")).click();
    try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }
}
