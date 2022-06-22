package MavenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWrite {
	public static String readData(int row,int col) throws IOException
	{
	String Path="C:\\Users\\This PC\\eclipse-workspace\\maven1\\id&pass.xlsx";
	File file=new File(Path);
	FileInputStream fis=new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheetAt(0);
	String s=sheet.getRow(row).getCell(col).getStringCellValue();
	return s;
	}
	//s
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement email =driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		email.sendKeys(readData(1,0));
		pass.sendKeys(readData(1,1));
		btn.click();
		Thread.sleep(10000);
		driver.close();
	}

}
