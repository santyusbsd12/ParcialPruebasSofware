package com.tdea.parcial.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AppTestLoginUser {
	
	private WebDriver webDriver;
	
	By usernameBox = By.name("username");
	By passwordBox = By.name("password");
	By buttonLogin = By.tagName("button");
	By buttonLogOut = By.tagName("a");
	By confirmationLogin = By.className("subheader");

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	void shouldAllowLogin() throws InterruptedException {
		if(webDriver.findElement(usernameBox).isDisplayed()) {
			Thread.sleep(1000);
			webDriver.findElement(usernameBox).sendKeys("tomsmith");
			webDriver.findElement(passwordBox).sendKeys("SuperSecretPassword!");
			
			webDriver.findElement(buttonLogin).click();
			Thread.sleep(4000);
			
			assertTrue(webDriver.findElement(confirmationLogin).isDisplayed());
		}else{
			System.out.println("No se ha podido iniciar sesion, test fallido");
		};
	}

	@AfterEach
	void tearDown() throws Exception {
		webDriver.quit();
	}
}
