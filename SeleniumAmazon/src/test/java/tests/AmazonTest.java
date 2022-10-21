package tests;

import org.junit.Test;

import functions.PrintList;
import org.junit.Before;
import org.junit.After;
import pages.AmazonMainPage;


public class AmazonTest extends AbstractTest {

  
  @Before
  public void setUp() {
    setupAmazonWebsite();
  }
  
  
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test01() {
   AmazonMainPage a = new AmazonMainPage(driver);
   a.typeToTopSearchBox("Zapatos");

   PrintList p = new PrintList(driver);
   p.printListBrans();
   p.printListHighestToLowest();
   p.validate5FirstProducts();

  }
}
