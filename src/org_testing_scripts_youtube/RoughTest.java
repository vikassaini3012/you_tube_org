package org_testing_scripts_youtube;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoughTest 

{
	
public ChromeDriver driver;   

@BeforeMethod	//BrowserLaunc + URL hit
public void beformethod()
{
	System.setProperty("webdriver.chrome.driver","C:\\JavaTraining\\chromedriver_win32\\chromedriver.exe");	
	driver = new ChromeDriver();
	driver.get("http://www.google.com");
	WebElement ele = driver.findElement(By.id("hplogo"));

	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	Point point = ele.getLocation(ele)
	
	
	// Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
	    eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png", screenshot);

	// Copy the element screenshot to disk
	File screenshotLocation = new File("C:\\images\\GoogleLogo_screenshot.png");
	FileUtils.copyFile(screenshot, screenshotLocation);
}
}



