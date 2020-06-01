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
public class Testfalloreg2Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
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
  public void testfalloreg2() {
    driver.get("https://webapp120200527070455.azurewebsites.net/");
    driver.manage().window().setSize(new Dimension(835, 728));
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("Input_Email")).click();
    vars.put("emailrandom", js.executeScript("return \"ual-\" + Math.floor(Math.random()*1500000)+\"@ual.es\""));
    driver.findElement(By.id("Input_Email")).sendKeys(vars.get("emailrandom").toString());
    driver.findElement(By.id("Input_Password")).sendKeys("Password1_");
    driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("Password2_");
    {
      WebElement element = driver.findElement(By.id("registerSubmit"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.id("registerSubmit"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("Input_ConfirmPassword-error"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    
    try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    
    driver.findElement(By.id("registerForm")).click();
    try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }
}
