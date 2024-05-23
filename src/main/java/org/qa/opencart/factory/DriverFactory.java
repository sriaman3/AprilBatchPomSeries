package org.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.qa.opencart.exception.FrameworkException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");
		switch (browser.toLowerCase().trim()) {
		case "chrome": {
			driver = new ChromeDriver();
			break;
		}
		case "edge": {
			driver = new EdgeDriver();
			break;
		}
		case "safari": {
			driver = new SafariDriver();
			break;
		}
		default:
			throw new FrameworkException("Please pass correct browser name: " + browser);
		}

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

		return driver;
	}

	public Properties init_prop() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
