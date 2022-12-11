package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListItemsPage extends BasePage {
	
	WebDriver driver;
	public ListItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	By toggleCheckBox = By.cssSelector("input[name='allbox']");
	By addItemField = By.cssSelector("input[name='data']");
	By addItemButton= By.cssSelector("input[value='Add']");
	By addCategoryField = By.cssSelector("input[name='categorydata']");
	By addCategoryButton= By.cssSelector("input[value='Add category']");
	By listItemCheckBox = By.cssSelector("input[name='todo[0]']");
	By removeItemButton = By.cssSelector("input[value='Remove']");

	@FindBy(how = How.XPATH, using = "//div[3]/a[3]")WebElement categoryItem;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Yes')]")WebElement yesRemoveCategoryButton;

	String beforeItemNum = "input[name='todo[";
	String afterItemNum = "]/span";		
	String beforeCategoryItem = "//div[3]/a[";
	String afterCategoryItem = "]";
	
	public void removeCategoryName() throws Exception {
		
		for (int i=0;i<=3; i++) {
			Thread.sleep(2000);
			categoryItem.click();
			 try {
				   Thread.sleep(2000);
				  } catch (InterruptedException e) {
				   e.printStackTrace();
				  }
			 
				yesRemoveCategoryButton.click();
				 try {
					   Thread.sleep(2000);
					  } catch (InterruptedException e) {
					   e.printStackTrace();
					  }
				 }
	}
	
	public void clickToggleButton() {
		driver.findElement(toggleCheckBox).click();
	}
	
	public void enterItemName() {
		driver.findElement(addItemField).sendKeys("BeenaJUnit"+ generateRandomNum(999));
	}
	
	public void clickAddItemButton() {
		driver.findElement(addItemButton).click();
	}
	
	public void enterCategoryName() {
		driver.findElement(addCategoryField).sendKeys("BeenaTest"+ generateRandomNum(999));
		
	}
	public void clickAddCategoryButton() {
		driver.findElement(addCategoryButton).click();
	}
	
	public void clickListItemCheckBox() {
		driver.findElement(listItemCheckBox).click();
	}
	
	public void clickRemoveItemButton() {
		driver.findElement(removeItemButton).click();
	}
	
	public void addItemToPage(int num) {	
		driver.findElement(addItemField).sendKeys("BeeUnit"+ generateRandomNum(999));
		driver.findElement(addItemButton).click();
		}

	public void addCategoryToPage(int num) {	
		driver.findElement(addCategoryField).sendKeys("ForestAnimals"+ generateRandomNum(999));
		driver.findElement(addCategoryButton).click();
		}
	
	public void removeAllPreviousItems() {
		driver.findElement(toggleCheckBox).click();
		driver.findElement(removeItemButton).click();		
	}

	public void addMultipleItemsToPage() {
		removeAllPreviousItems();		
		for (int i=0; i<5;i++) {
			addItemToPage(i);
		}
	}
	public void addMultipleCategoriesToPage() {
		for (int i=0; i<2;i++) {
			addCategoryToPage(i);
		}
	}
	
	public boolean isElementPresent() {
		try {
			return 	driver.findElement(listItemCheckBox).isDisplayed();
		}catch (NoSuchElementException e) {
			System.out.println("Single selected item has been successfully removed. Item does not exist.");
		return false;
		}	
	}		
}