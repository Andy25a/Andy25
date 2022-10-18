package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class Test01Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  private static final String TYPE_DRIVER="webdriver.chrome.driver";
  private static final String PATH_DRIVER="./src/test/resources/webdriver/chromedriver.exe";
  JavascriptExecutor js;
  
  
  
  @BeforeClass
  public static void setUpBeforeClass() {
  System.out.println("Start of tests");
  System.setProperty(TYPE_DRIVER, PATH_DRIVER);   
}
  
  @Before
  public void setUp() {
      
	  
	  driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    
    
    
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test01() {
    driver.get("https://www.amazon.com/");
    driver.manage().window().setSize(new Dimension(1650, 984));
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("zapatillas");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    js.executeScript("window.scrollTo(0,506)");
    driver.findElement(By.cssSelector(".a-unordered-list:nth-child(4) .a-expander-prompt")).click();
    driver.findElement(By.cssSelector("#p_89\\/adidas label")).click();
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

    driver.findElement(By.id("a-autoid-0-announce")).click();
    driver.findElement(By.id("s-result-sort-select_2")).click();
    driver.findElement(By.cssSelector(".sg-col-4-of-12:nth-child(3) .s-image:nth-child(1)")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.findElement(By.id("productTitle")).click();
    driver.findElement(By.cssSelector(".a-span12:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.id("nav-logo-sprites"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("title")).click();
    driver.findElement(By.cssSelector(".a-price-range")).click();
    driver.findElement(By.id("productTitle")).click();
    driver.findElement(By.id("productTitle")).click();
    driver.findElement(By.id("productTitle")).click();
    driver.findElement(By.cssSelector(".a-span12:nth-child(2)")).click();
    driver.findElement(By.id("title")).click();
    driver.findElement(By.cssSelector(".a-span12:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".hm-icon-label"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("productTitle")).click();
    driver.findElement(By.cssSelector(".a-span12:nth-child(2)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".sg-col-4-of-12:nth-child(3) .s-product-image-container .a-section"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".a-link-normal > .a-text-bold")).click();
  }
}
