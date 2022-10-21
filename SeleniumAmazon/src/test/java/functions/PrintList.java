package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;
import utils.AssertUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class PrintList extends AbstractPage {
    private static final By ALL_RETURNED_ELEMENT = By.xpath("//div[@data-component-type='s-search-result']//h2");
    private static final By TEXT_PRICE_WHOLE = By.xpath("//span[@class='a-price-whole']");
    private static final By TEXT_PRICE_FRACTION = By.xpath("//span[@class='a-price-fraction']");
    private static final By TEXT_PRICE_WITHOUT_FRACTION = By.xpath("//span[@class = 'a-offscreen']");

    public PrintList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public void brands() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
    	driver.findElement(By.xpath("//*[@id=\"p_89/adidas\"]/span/a/span")).click();	
    }
    
    
    public void orderHighestToLowest() {
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_2")).click();
    }

    
    public void printListBrans() {
    	brands();
    	System.out.println("----Imprimir el nombre y precio de los 5 primeros productos marca ---- \n");
    	for (int j =0;j<5;j++){  
    		
    		listAll a= new listAll(driver);
    		List<String> listTitle =a.listItemTitle(j);
    		 System.out.println("-Item "+(j+1)+": "+listTitle.get(j));

    		List<Double> listPrice= a.listPrices(j);
            System.out.println("Price: "+ listPrice.get(j));

    	}
    }
    
   public void printListHighestToLowest() {
	   orderHighestToLowest();
	   System.out.println("\n ---Imprimir el nombre y precio de los 5 primeros productos marca Adidas - Ordenar por el precio de mayor a menor--- \n");
	   for (int j =0;j<5;j++){
   		listAll a= new listAll(driver);
		List<String> listTitle =a.listItemTitle(j);
   		System.out.println("-Item "+(j+1)+": "+ listTitle.get(j));        	
   		List<Double> listPrice= a.listPrices(j);
        System.out.println("Price: "+ listPrice.get(j));
    	}	
    }
   
    
   
   public void validate5FirstProducts() {
   	brands();
   	System.out.println("\n----Validar que los 5 primeros productos tengan su nombre y precio ---- \n");
    System.out.println("---Passed--");
	for (int j =0;j<5;j++){
   	List<String> searchResultsTitles = driver.findElements(ALL_RETURNED_ELEMENT).stream()
            .map(res -> res.getText())
            .collect(Collectors.toList());
    String ElementTitle = searchResultsTitles.get(j);
    boolean checkIfTitleExist = searchResultsTitles.contains(ElementTitle);
    System.out.println("--Item-- "+(j+1)); 
    AssertUtils.assertTrue(checkIfTitleExist, "Se valido correctamente el nombre: "+ElementTitle);
    String res = "";
    try {
        List<WebElement> priceWithoutFractionList = driver.findElements(TEXT_PRICE_WITHOUT_FRACTION);
        String priceWhole = priceWithoutFractionList.get(j).getText().replace("$", "");
        res = priceWhole;
    } catch (Exception e) {
        System.out.println("Price contains fraction...");
    }
    List<WebElement> priceWholeList = driver.findElements(TEXT_PRICE_WHOLE);
    String priceWhole = priceWholeList.get(j).getText();
    List<WebElement> priceFractionList = driver.findElements(TEXT_PRICE_FRACTION);
    String priceFraction = priceFractionList.get(j).getText();
    res = priceWhole + "." + priceFraction;
    double finalPrice = Double.valueOf(res);
	listAll a= new listAll(driver);
    List<Double> finalPriceList = a.listPrices(j);
	// Verify the price on cart is like the Product we selected
    boolean condicion1 = (finalPrice == finalPriceList.get(j));
    AssertUtils.assertTrue(condicion1, "Se valido correctamente el precio: "+finalPriceList.get(j));

    
    
    
	}	
   	
   }
    
    
}