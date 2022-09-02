package testBase;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
//note:class-32 with pravon

public class BaseClass {
	
	public WebDriver dr;
	public Logger logger;//for log4j
	public ResourceBundle rb; //for reading property file from config.properties
	
	@BeforeClass(groups={"master","sanity","regression"})
	@Parameters({"browser"})
	public void setup(String br) {
		
		//load config.properties name like config not properties
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass()); //for log4j
		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); //with this runing chromebrowser
			dr=new ChromeDriver();
			logger.info("Launched chrome browser");
			
		}else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup(); //runing edgedrive
			dr=new EdgeDriver();
			logger.info("Launched edge browser");
			
		}else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup(); //runing firefoxdriver
			dr=new FirefoxDriver();
			logger.info("Launched firefox browser");
		}
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		dr.close();
	}

	public String randomesstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}

	public int randomeNumber() {
		String generatedstring2=RandomStringUtils.random(5);
		return (Integer.parseInt(generatedstring2));
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
	
	
	
	
	


}
