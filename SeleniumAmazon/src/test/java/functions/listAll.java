package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.AbstractPage;

public class listAll extends AbstractPage{
	
	public listAll(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


    private static final By ALL_RETURNED_ELEMENT = By.xpath("//div[@data-component-type='s-search-result']//h2");
    private static final By PRICE_LIST = By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price-whole']");
    private static final By PRICE_FRACTION_LIST = By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price-fraction']");

public List<Double> listPrices(int n) {
    	
        List<WebElement> listPriceWE = driver.findElements(PRICE_LIST);
        List<Double> listPrice = new ArrayList<>();
        for (WebElement lp : listPriceWE) {
            String removeCommasFromPrice = lp.getText().replace(",", "");
            if (removeCommasFromPrice.equals("")) {
                listPrice.add(0.0);
            } else {
                listPrice.add(Double.valueOf(removeCommasFromPrice));
            }
        }
        List<WebElement> listPriceFractionWE = driver.findElements(PRICE_FRACTION_LIST);
        List<Double> listPriceFraction = new ArrayList<>();
        for (WebElement lpFraction : listPriceFractionWE) {
            if (lpFraction.getText().equals("") || Double.valueOf(lpFraction.getText()) == 00) {
                listPriceFraction.add(0.0);
            } else {
                double res = Double.valueOf(lpFraction.getText()) / 100;
                listPriceFraction.add(res);
            }
        }
        List<Double> finalPriceList = new ArrayList<>();
        for (int i = 0; i < listPrice.size(); i++) {
            if (listPrice.get(i) + listPriceFraction.get(i) > 0.0) {
                finalPriceList.add(listPrice.get(i) + listPriceFraction.get(i));
            }
        }
		return finalPriceList;
    }
    
    
    public List<String> listItemTitle(int n) {
        List<String> searchResultsTitles = driver.findElements(ALL_RETURNED_ELEMENT).stream()
                .map(res -> res.getText())
                .collect(Collectors.toList());
		return searchResultsTitles;
    }
}
