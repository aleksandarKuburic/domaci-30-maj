import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*
Otići na http://www.strela.co.rs/,
kliknuti na dugme Prodavnica u headeru,
izabrati opciju Lukovi - Bows iz leve navigacije,
potom kliknuti na luk koji se zove Samick Sage, i onda
proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
 */

public class main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Andromeda\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.navigate().to("http://www.strela.co.rs/");
        driver.manage().window().maximize();


        WebElement pickProdavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]"));
        pickProdavnica.click();

        WebElement pickLukovi = driver.findElement(By.xpath
                ("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        pickLukovi.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));

        WebElement pickSamickSage = driver.findElement(By.xpath
                ("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        pickSamickSage.click();

        WebElement bowHeader = driver.findElement(By.xpath
                ("//*[@id=\"ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel\"]"));

        String header = bowHeader.getText();

        if(header.contains("Samick")){
            System.out.println("Yaaaay!");
        }
        else{
            System.out.println("Nyyyyy!");
        }



    }
}
