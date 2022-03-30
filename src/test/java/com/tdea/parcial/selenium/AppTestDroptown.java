package com.tdea.parcial.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class AppTestDroptown {

	private WebDriver webDriver;

	@BeforeEach
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void shouldShowDropdownAndAllowSelectAnOption() {
		WebElement selectElement = webDriver.findElement(By.id("dropdown"));
		Select selectBox = new Select(selectElement);
		selectBox.selectByVisibleText("Option 2");

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		WebElement optionSelected = selectBox.getFirstSelectedOption();

		Assertions.assertEquals("Option 2", optionSelected.getText());
	}

	@AfterEach
	public void tearDown() throws Exception {
		//webDriver.quit();
	}
}
