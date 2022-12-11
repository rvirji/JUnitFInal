package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.ListItemsPage;
import util.BrowserFactory;

public class ListItemsTest {
	WebDriver driver;
	ListItemsPage listItemsPage;
	String beforeItemNum = "input[name='todo[";
	String afterItemNum = "]']";
	
@Before	
public void init() {	
	driver = BrowserFactory.init();
	
	}

@Test
public void validateAllitemsCheckBoxSelectedOrNot() throws Exception {		
	listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	listItemsPage.addMultipleItemsToPage();
	listItemsPage.clickToggleButton();	
	Thread.sleep(2000);
	for(int i=0; i<5; i++) {
	boolean itemsChecked = driver.findElement(By.cssSelector(beforeItemNum+i+afterItemNum)).isSelected();			
		if (itemsChecked!= true) {
			System.out.println("All items in list are not checked");		
			}
		else {
			System.out.println("All items in list are checked");	
		}
	}
}
@Test
public void validateSingleSelectedItemCanBeRemovedOrNot() {
	listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	listItemsPage.removeAllPreviousItems();
	listItemsPage.addMultipleItemsToPage();
	listItemsPage.clickListItemCheckBox();
	listItemsPage.clickRemoveItemButton();
	listItemsPage.isElementPresent();
}

@Test
public void validatetoggleAllSelectedItemsCanBeRemovedOrNot() {
	listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
	listItemsPage.removeAllPreviousItems();
	listItemsPage.addMultipleItemsToPage();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[name='todo[4]']")));
	
	listItemsPage.clickToggleButton();
	listItemsPage.clickRemoveItemButton();
	try {
	for(int i=0; i<5; i++) {
		boolean itemsChecked = driver.findElement(By.cssSelector(beforeItemNum+i+afterItemNum)).isSelected();			
			if (itemsChecked!= true) {
				System.out.println("Toggle All selected items in list are removed");		
				}
			else {
				System.out.println("Toggle All selectedtems in list are not removed");	
			}
	}
	}
	catch (NoSuchElementException e) {
		System.out.println("\"Toggle All & Remove\" items have been removed. Items do not exist");
		
	}
}

@Test
public void zdeletecategories() throws Exception {
listItemsPage = PageFactory.initElements(driver, ListItemsPage.class);
listItemsPage.removeCategoryName();

}	

@After
public void tearDown() {
	driver.close();
	driver.quit();
	}
	
}


