package WH.Test.MasterFramework.WHBaseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class WebControlExtensions 
{
	public static void hoverAndClick( WebDriver driver, WebElement element)
	{   
		try 
		{
			Thread.sleep(2000);
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click().build().perform();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void hover(WebDriver driver, WebElement element)
	{   
		try 
		{
			Thread.sleep(3000);
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    public static void SelectDropDown(WebDriver driver, String element, String value, String elementType)
    {
    	try 
    	{
			Thread.sleep(2000);
			  if (elementType == "Id")
		            new Select(DriverContext.driver.findElement(By.id(element))).selectByValue(value);

		        if (elementType == "XPath")
		            new Select(DriverContext.driver.findElement(By.xpath(element))).selectByValue(value);

		        if (elementType == "Name")
		            new Select(DriverContext.driver.findElement(By.name(element))).selectByVisibleText(value);

		        if (elementType == "CssSelector")
		            new Select(DriverContext.driver.findElement(By.cssSelector(element))).selectByValue(value);

		        if (elementType == "ClassName")
		            new Select(DriverContext.driver.findElement(By.className(element))).selectByValue(value);
		} 
    	catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public static void SelectItemByValueFromDDL(WebElement element, String value)
    {
    	try 
    	{
			Thread.sleep(2000);
			 Select ddlElement = new Select(element);
		     ddlElement.selectByValue(value);
		} 
    	catch (InterruptedException e) {
			e.printStackTrace();
		}
       
    }
}
