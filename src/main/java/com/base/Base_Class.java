package com.base;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {

	public static WebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	protected static void Validation(String act,String exp) {
		try {
			assertEquals(act, exp);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALIDATION");
		}
	}

	protected static WebDriver browserlaunch(String browser) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BROWSER_LAUNCH");
		}
		driver.manage().window().maximize();

		return driver;

	}

	protected static void websiteLaunch(String URL) {
		try {
			driver.get(URL);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING WEBSITE_LAUNCH");
		}
	}

	protected static void browserQit() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BROWSERQUIT");
		}
	}

	protected static void browserClose() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BROWSERCLOSE");
		}
	}

	protected static void navigate_to(String navigateurl) {
		try {
			driver.navigate().to(navigateurl);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATE_TO_URL");

		}
	}

	protected static void navigate(String navigate) {
		try {
			if (navigate.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (navigate.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (navigate.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATION");
		}
	}

	protected static void alert(String alert) {
		try {
			if (alert.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			} else if (alert.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();
			} else if (alert.equalsIgnoreCase("gettext")) {
				String text = driver.switchTo().alert().getText();
				System.out.println(text);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING ALERT");

		}
	}

	protected static void alertsendkey(String alert) {
		try {
			driver.switchTo().alert().sendKeys(alert);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING ALERTSENDKEYS");
		}
	}

	protected static void mouseActions(String function, WebElement element) {
		Actions action = new Actions(driver);
		try {
			if (function.equalsIgnoreCase("doubleclick")) {
				action.doubleClick(element).perform();
			} else if (function.equalsIgnoreCase("clickandhold")) {
				action.clickAndHold(element).perform();
			} else if (function.equalsIgnoreCase("right click")) {
				action.contextClick(element).perform();
			} else if (function.equalsIgnoreCase("movetoelement")) {
				action.moveToElement(element).perform();
			} else if (function.equalsIgnoreCase("click")) {
				action.click(element).perform();
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING MOUSEBASEDACTIONS");
		}

	}

	protected static void dragAndDrop(WebElement source, WebElement drop) {
		Actions action = new Actions(driver);
		try {
			action.dragAndDrop(source, drop).perform();

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING DRAGANDDROP");
		}
	}

	protected static void switchframesUsingIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING FRAMEUSING_INDEX");
		}
	}

	protected static void switchframesUsingWebElement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING FRAMEUSING_WEBELEMENTS");
		}
	}

	protected static void switchframesUsingid(String id) {
		try {
			driver.switchTo().frame(id);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING FRAMEUSING_ID");
		}

	}

	protected static void outfromFrame(String frame) {
		try {
			if (frame.equalsIgnoreCase("parentframe")) {
				driver.switchTo().parentFrame();
			} else if (frame.equalsIgnoreCase("allframeout")) {
				driver.switchTo().defaultContent();
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING FRAMEOUT");
		}
	}

	protected static void keyboard_Actions(String action) {
		try {
			Robot actions = new Robot();
			if (action.equalsIgnoreCase("enter")) {
				actions.keyPress(KeyEvent.VK_ENTER);
			} else if (action.equalsIgnoreCase("tab")) {
				actions.keyPress(KeyEvent.VK_TAB);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING KEYBOARD_ACTIONS");
		}

	}

	protected static void selectOptions(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALUE SELECTING");
		}
	}

	protected static void deselectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALUE DESELECTING");
		}

	}

	protected static void elementToClick(WebElement element) {
		try {
			element.click();

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING ELEMENTCLICK");
		}
	}

	protected static void checking_Functionality(String function, WebElement element) {
		try {
			if (function.equalsIgnoreCase("isenable")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
			} else if (function.equalsIgnoreCase("isdisplayed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			} else if (function.equalsIgnoreCase("isselected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING CHECKING_FUNCTIONALITY");
		}
	}

	protected static void getDropdownValue(WebElement element, String function) {
		try {
			Select select = new Select(element);
			if (function.equalsIgnoreCase("ismultiple")) {
				boolean multiple = select.isMultiple();
				System.out.println(multiple);
			} else if (function.equalsIgnoreCase("getoptions")) {
				List<Object> list = new ArrayList<Object>();
				List<WebElement> options = select.getOptions();
				for (WebElement webElement : options) {
					list.add(webElement);
				}
				System.out.println(list);
			} else if (function.equalsIgnoreCase("getfirstselectedoption")) {
				WebElement firstSelectedOption = select.getFirstSelectedOption();
				System.out.println(firstSelectedOption);
			} else if (function.equalsIgnoreCase("getallselectedoption")) {
				List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
				for (WebElement webElement : allSelectedOptions) {
					System.out.println(webElement.getText());
				}
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET_THE_VALUE");
		}
	}

	protected static void get_Functionality(String function) {
		try {
			if (function.equalsIgnoreCase("gettitle")) {
				String title = driver.getTitle();
				System.out.println(title);
			} else if (function.equalsIgnoreCase("getcurrentturl")) {
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE IN GET_FUNCTIONALITY");
		}
	}

	protected static void get_Text(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE IN GETTEXT");
		}
	}

	protected static void implicitWait(String function, int duration) {
		try {
			if (function.equalsIgnoreCase("second")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
			} else if (function.equalsIgnoreCase("minutes")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
			} else if (function.equalsIgnoreCase("nanos")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofNanos(duration));
			}
		}

		catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING IMPLICITWAIT");
		}
	}

	protected static void explicitwait(WebElement element, int sec) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING EXPLICITWAIT");
		}
	}

	protected static void takeScreenshot(String filelocation) throws IOException {
		try {
			Date currentDate = new Date();
			String replace = currentDate.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File des = new File(filelocation + replace + ".png");
			FileHandler.copy(source, des);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCREENSHOT");

		}
	}

	protected static void scrolls(String direction) {
		try {
			if (direction.equalsIgnoreCase("top")) {
				js.executeScript("window.scrollBy(0,0)");
			} else if (direction.equalsIgnoreCase("up")) {
				js.executeAsyncScript("window.scrollBy(0,-150)");
			} else if (direction.equalsIgnoreCase("down")) {
				js.executeAsyncScript("window.scrollBy(0,150)");
			}
		

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCROLL");
		}
	}
	
	protected static void jsfunction(WebElement element,String function) {
		try {
			if(function.equalsIgnoreCase("scrollintoview")) {
			  js.executeScript("arguments[0].scrollIntoView();", element);
			}
			else if(function.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click();", element);
				
			}
		}
			catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCROLLintoview");		
			}
		
		}
		


	protected static void windowHandle(int number) {
		try {
			List<String> allwindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(allwindow.get(number));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING WINDOWHANDLE");
		}
	}

	protected static void sendkey(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SENDKEY");
		}
	}
	
	protected static void wait(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}
		
	}


