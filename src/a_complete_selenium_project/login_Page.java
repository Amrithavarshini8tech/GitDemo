package a_complete_selenium_project;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class login_Page {

	public static void main(String[] args) throws Exception {

		// 1. Chrome setup
		System.out.println("Gitstuff");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amrit\\eclipse\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// 2.Log in
		driver.findElement(By.xpath("//input[@name='username']")).click();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		// 3. Check the Page Title
		String title = driver.getTitle();
		title.equals("OrangeHRM");

		// 4. Check the menu options
		// declare an arrray with the expected menu options and compare with the list
		// fetched from the List of webelements
		String menu[] = { "Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard",
				"Directory", "Maintenance", "Claim", "Buzz" };
		List<WebElement> menuOptions = driver
				.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));

		System.out.println("length= " + menu.length);
		for (int i = 0; i < menu.length; i++) {
			String fetchedMenu = menuOptions.get(i).getText();
			System.out.println(fetchedMenu);
			fetchedMenu.equals(menu[i]);
		}

		// 5.Admin Tab validation
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1000);
		// a. find the number of records
		String value = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
		System.out.println(value);
		System.out.println(value.substring(1, 2));

		// 6. Dashboard Tab validation
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")).getText();
		if (text.equals("Dashboard")) {
			System.out.println("Dashboard validated");
		}

		// 5. Log Out

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[@class='oxd-userdropdown-link']")).click();
		driver.quit();

	}

}
