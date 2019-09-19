package br.com.example.helloworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSiteTest {
	private WebDriver driver;	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rfrana\\Desktop\\rodrigo\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://localhost:4200/");
		// driver.get("https://www.seleniumhq.org");
		// assertTrue("Título inválido",
		// driver.getTitle().contentEquals("HelloWorldApp"));
		driver.findElement(By.id("inpUsuario")).clear();
		driver.findElement(By.id("inpUsuario")).sendKeys("GOUVEA");
		driver.findElement(By.id("inpSenha")).clear();
		driver.findElement(By.id("inpSenha")).sendKeys("Teste1234");
		driver.findElement(By.id("btnOnSubmit")).click();
		
		// driver.findElement(By.xpath("/html/body/app-dashboard/div/div/nav/ul/li[3]/a")).click();
		// driver.findElement(By.id("btnNavBar")).click();
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}
}
